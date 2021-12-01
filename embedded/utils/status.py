import os
from typing import Tuple

__utils_folder = os.path.normpath(os.path.dirname(__file__) + os.sep)
__status_file = str(__utils_folder + '.status')
__animal_prefix = 'animal='
__watering_prefix = 'watering='

def __read_status_file() -> Tuple[bool, bool]:
    """
    Returns status of automated systems in (animal status, watering status) format

    Args:
        None:
    Returns
        Tuple(bool,bool): Tuple containing status of automated systems
    """
    status: any

    with open(__status_file, 'r') as FILE:
        status = FILE.read.splitlines()
    status.split

    animal_status = True if status[0].split('=')[1] == 'enabled' else False
    watering_status = True if status[1].split('=')[1] == 'enabled' else False

    return (animal_status, watering_status)


def get_automatic_watering_status():
    with open(__status_file, 'r') as FILE:
        FILE.r

def set_automatic_watering_status():

def get_animal_detection_status():

def set_automatic_watering_status():

