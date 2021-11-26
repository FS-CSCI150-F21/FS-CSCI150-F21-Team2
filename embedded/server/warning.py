from enum import Enum
import requests
from time import time

from utils.logging import log
from server.endpoints import Endpoint
import server.json_bodies as body
from server.connection import get_registration

class WarningType(str):
    ANIMAL_DETECTED = 'animal'
    WATER_LEAK = 'leak'

def generate_warning(type: str, msg: str = '', img_path: str = ''):
    """
    Send warning to server
    Args:
        msg: str
            Custom message to send to server
    Returns:
        None
    """
    log(f'Generating warning: [{type}].')

    # Get registration
    _, uuid = get_registration()
    # Write warning
    cur_time = time()
    warning_body = body.Warning(gardenId=uuid, timestamp=cur_time, type=type, message=msg).__dict__
    # Attempt to send warning
    warn: any
    try:
        warn = requests.post(url=Endpoint.WARNING_ENDPOINT, json=warning_body)
        if type == WarningType.ANIMAL_DETECTED:
            with open(img_path, 'rb') as IMAGE_FILE:
                image_body = body.Image(gardenId=uuid, timestamp=cur_time).__dict__
                image = requests.post(url=Endpoint.IMAGE_ENDPOINT, json=image_body, files=IMAGE_FILE)
    except Exception as e:
        log('Connection ERROR. Warning was not sent to the server.')
        log(f'ERROR Details:{e}')
        raise Exception('Warning could not be sent to the server!')

    log('Warning sent to server.')