import requests

import server.connection as sc
import server.json_bodies as body
from server.endpoints import Endpoint
from utils.logging import log
import sensor_data.gather_sensor_data as sd

def send_current_data():

    data = sd.gather_all_sensor_data().__dict__

    try:
        r = requests.post(Endpoint.DATA_ENDPOINT, json=data)
    except Exception as e:
        log('Failed to send data to server!')
        log(f'ERROR Details:{e}')
    pass

