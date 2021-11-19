from enum import Enum
import requests

from utils.logging import log
from server.endpoints import Endpoint
import server.json_bodies as body
from server.connection import get_registration

class WarningType(str, Enum):
    ANIMAL_DETECTED = 'animal'
    WATER_LEAK = 'leak'

def generate_animal_warning(timestamp: int, msg: str = ''):
    """
    Send animal warning to server
    Args: 
    """
    log('Generating warning for detected animal.')

    # Get registration
    _, uuid = get_registration()
    # Write warning
    warning_body = body.Warning(gardenId=uuid, timestamp=timestamp, type=WarningType.ANIMAL_DETECTED, message=msg).__dict__
    # Attempt to send warning
    warn: any
    try:
        warn = requests.post(url=Endpoint.WARNING_ENDPOINT, json=warning_body)
    except requests.exceptions.RequestException as e:
        log('Connection ERROR. Warning was not sent to the server.')
        log(f'ERROR Details:{e}')
        raise Exception('Warning could not be sent to the server!')

    log('Warning sent to server.')


def generate_leak_warning(timestamp: int):
    log('Generating warning for detected leak')