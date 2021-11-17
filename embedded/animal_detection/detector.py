import tensorflow as tf
from time import sleep, time
from datetime import datetime
import os

# local imports
from utils.logging import log
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

    log('Loading model (this may take a while)...')
    log(f'{_model_path}')
    model = tf.saved_model(_model_path)
    log('Loaded model.')

    while (True):
        log('Capturing image...')
        img_timestamp = time()
        _img_path = camera.capture_image()
        log('Captured image.')

        if _img_path is None:
            log(f'Image capture failed, retrying in {frequency} seconds...')
            sleep(float(frequency))
            continue

        log('Loading image...')
        img = tf.keras.utils.load_img(_img_path, target_size=(768,768))
        img = tf.keras.utils.img_to_array(img, dtype='uint8')
        img = tf.expand_dims(img, 0)
        log('Loaded image.')

        log('Searching image for animal...')
        prediction = model(img)
        class_ids = prediction["detection_classes"][0]
        detection_scores = prediction["detection_scores"][0]

        animal_detected = False
        for score, id in zip(detection_scores, class_ids):
            if score > 0.50 and id in _animal_labels:
                animal_detected = True
                log(f'{_animal_labels[id]} detected with {score*100}% certainty.')

        sleep(float(frequency))