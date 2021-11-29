import requests
from time import time
from datetime import datetime
from requests_toolbelt.multipart.encoder import MultipartEncoder

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
    timestamp = str(datetime.utcnow())
    timestamp_t = timestamp[:10] + 'T' + timestamp[11:]
    print(timestamp)
    warning_body = body.Warning(gardenId=uuid, timestamp=timestamp_t, type=type, message=msg).__dict__
    print(warning_body)
    # Attempt to send warning
    try:
        warn = requests.post(url=Endpoint.WARNING_ENDPOINT,
                                json=warning_body)
        # Code for sending image, disabled at the moment due to unknown request hang
        # print(warn)
        # if type == WarningType.ANIMAL_DETECTED:

        #     img_data = MultipartEncoder(
        #         fields={'gardenId': uuid,
        #                 'timestamp': timestamp,
        #                 'image': (img_path.split('/')[-1],
        #                             open(img_path, 'rb'),
        #                             'image/jpeg')
        #                 })

        #     print(Endpoint.IMAGE_ENDPOINT)
        #     r = requests.post(Endpoint.IMAGE_ENDPOINT,
        #                         data=img_data,
        #                         headers={'Content-Type': img_data.content_type})
        #     print(r)
            
            # img_data = (img_path.split('/')[-1], open(img_path, 'rb'), 'application/octect-stream')
            # img_body = body.Image(gardenId=uuid, timestamp=str(cur_time), image=img_data).__dict__
            # img_data = MultipartEncoder(fields=img_body)
            # print(Endpoint.IMAGE_ENDPOINT)

            # image = requests.post(url=Endpoint.IMAGE_ENDPOINT,
            #                     headers={'Content-Type' : img_data.content_type},
            #                     data=img_data)
            # print(image)

    except Exception as e:
        log('Connection ERROR. Warning was not sent to the server.')
        log(f'ERROR Details:{e}')
        raise Exception('Warning could not be sent to the server!')

    log('Warning sent to server.')