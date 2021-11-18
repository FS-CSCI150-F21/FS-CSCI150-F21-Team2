from enum import Enum
import os

# Base URL
__server_folder = os.path.normpath(os.path.dirname(__file__) + os.sep)
__base_url : any
with open(str(__server_folder + '/.url'), 'r') as FILE:
    __base_url = FILE.readline()

class Endpoint(str, Enum):
    REGISTRATION_ENDPOINT = str(__base_url + 'api/v1/garden_registration/pi')
    IMAGE_ENDPOINT = str(__base_url + 'api/v1/images')
    WARNING_ENDPOINT = str(__base_url + 'api/v1/notifications')