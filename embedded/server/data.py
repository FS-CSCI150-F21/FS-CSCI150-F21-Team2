import requests

import server.connection as sc
import server.json_bodies as body
from server.endpoints import Endpoint
from utils.logging import log

def send_current_data():
    _, uuid = sc.get_registration()

    # get some data in future as sensors are not hooked up, function should
    # return object of type Data

    data = body.Data().__dict__

    try:
        r = requests.post(Endpoint.DATA_ENDPOINT, json=data)
    except Exception as e:
        log('Failed to send data to server!')
        log(f'ERROR Details:{e}')
    pass

