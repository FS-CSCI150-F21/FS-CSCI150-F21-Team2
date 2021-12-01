import os

class Endpoint(str):
    
    __server_folder = os.path.normpath(os.path.dirname(__file__) + os.sep)
    __url_file = open(str(__server_folder + '/.url'), 'r')
    __base_url = __url_file.readline()
    __url_file = __url_file.close()
    REGISTRATION_ENDPOINT = str(__base_url + 'api/v1/garden_registration/pi')
    IMAGE_ENDPOINT = str(__base_url + 'api/v1/garden_images')
    WARNING_ENDPOINT = str(__base_url + 'api/v1/notifications')
    DATA_ENDPOINT = str(__base_url + 'api/v1/garden_data_collection/save')
    LISTEN_DATA_ENDPOINT = str(__base_url + 'api/v1/garden_data_collection/latest')