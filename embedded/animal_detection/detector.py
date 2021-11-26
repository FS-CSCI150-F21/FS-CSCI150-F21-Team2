import tensorflow as tf
import tensorflow_hub as tfhub
from time import sleep, time
from datetime import datetime, timedelta
import requests
import os

# local imports
from utils.logging import log
from server.endpoints import Endpoint
import server.warning as sw
import sensors.camera as camera

def detection_loop(frequency: int = 30000, detection_threshold: float = 0.5):
    """
    Animal detection loop that captures images on a regular interval
    and uses tensorflow to search them for animals. If an animal is detected
    a warning is raised.
    Args:
        frequency: int (default = 30000)
            Frequency of how often system should check for an animal in milliseconds
        detection_threshold: float (default = 0.5)
            Certainty of model required for warning to be triggered
    Returns: None
    """
    frequency = float(frequency / 1000)

    _root = str(os.path.normpath(os.path.dirname(__file__) + os.sep + os.pardir))
    _model_path = str(_root + '/animal_detection/models/edet')
    _label_path = str(_model_path + '/animal_labels.txt')
    
    log('Importing labels for animal detection...')    
    _animal_labels = {}
    with open(_label_path, 'r') as FILE:
        labels = FILE.read().splitlines()
        for label in labels:
            label = label.split(':')
            _animal_labels[int(label[0])] = label[1] 
    log('Imported labels.')

    now = datetime.now()
    log('Loading model (this may take a while)...')
    model = tfhub.load("https://tfhub.dev/tensorflow/efficientdet/d2/1")
    now = datetime.now() - now
    log(f'Loaded model in {now}.')

    next_capture_time = datetime.now()
    while (True):
        try:
            next_capture_time += timedelta(seconds=frequency)
            log('Capturing image...')
            _img_path = camera.capture_image()
            log('Captured image.')

            if _img_path is None:
                log(f'Image capture failed, retrying in {frequency} seconds...')
                sleep(float(frequency))
                continue

            log('Loading image...')
            img = tf.io.decode_image(tf.io.read_file(_img_path))
            img = tf.reshape(img, [-1, 800, 600, 3])
            log('Loaded image.')

            now = datetime.now()
            log('Searching image for animal...')
            prediction = model(img)
            detection_scores = prediction["detection_scores"][0]
            class_ids = prediction["detection_classes"][0]
            now = datetime.now() - now
            print(f'Searched image in {now}.')

            animals_detected = []
            for score, id in zip(detection_scores, class_ids):
                score = float(score)
                id = int(id)
                if score > 0.5 and id in _animal_labels:
                    cur_animal = _animal_labels[id]
                    animals_detected.append(cur_animal)
                    log(f'{cur_animal} detected with {score*100}% certainty.')

            if animals_detected:
                # Send warning to server
                sw.generate_warning(type=sw.WarningType, msg=f'Animal(s) detected: {str(animals_detected)[1:-1]}')
                # Send image to server
                with open(_img_path, 'rb') as IMAGE_FILE:
                    img_request = requests.post(url=Endpoint.IMAGE_ENDPOINT, files=IMAGE_FILE)

        except Exception as e:
            log('ERROR: Something went wrong in the animal detection process...')
            log(f'ERROR Details:{e}')

        # Sleep until next image should be taken
        if next_capture_time > datetime.now():
            stime = (next_capture_time - datetime.now()).total_seconds()
            if stime > 0:
                sleep(stime)