from datetime import datetime
from threading import Thread, Lock
import os

mutex = Lock()

def capture_image():
    """
    Captures an image and returns the path to the captured image
    args:
        None
    returns:
        str: path to image
    """

    mutex.acquire()

    _image_folder = str(os.path.normpath(os.path.dirname(__file__) + os.sep + os.pardir) + '/sensor_data/images/')

    # prevent access attempt of non-existent folder
    if not os.path.isdir(_image_folder):
        os.mkdir(_image_folder)

    # provide unique name for each image
    timestamp = datetime.utcnow().strftime("%Y_%m_%d_%H%M%S")
    image_path = str(_image_folder + timestamp + '.jpeg')

    # run scipr to capture image
    os.system(f'./camera.sh {image_path}')

    mutex.release()

    return image_path
