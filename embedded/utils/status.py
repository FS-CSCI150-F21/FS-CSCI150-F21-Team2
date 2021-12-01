import os
from typing import Tuple

__utils_folder = os.path.normpath(os.path.dirname(__file__) + os.sep)
__status_file = str(__utils_folder + '/.status')
__animal_prefix = 'animal='
__watering_prefix = 'watering='

def __read_status_file() -> Tuple[bool, bool]:
    """
    Returns status of automated systems in (animal status, watering status) format

    Args:
        None
    Returns
        Tuple(bool,bool): Tuple containing status of automated systems
    """
    status: any

    with open(__status_file, 'r') as FILE:
        status = FILE.read().splitlines()

    animal_status = True if status[0].split('=')[1] == 'enabled' else False
    watering_status = True if status[1].split('=')[1] == 'enabled' else False

    return (animal_status, watering_status)

def __write_status_file(status: Tuple[bool, bool]):
    """
    Writes status of automated systems to .status file

    Args:
        Tuple(bool,bool): State to set status of automated systems to
    Returns:
        None
    """

    animal_status_line = __animal_prefix + ('enabled\n' if status[0] else 'disabled\n')
    watering_status_line = __watering_prefix + ('enabled' if status[1] else 'disabled')
    
    with open(__status_file, 'w') as FILE:
        FILE.writelines([animal_status_line, watering_status_line])


def get_animal_detection_status() -> bool:
    """
    Returns status of animal detection system
    Args:
        None
    Returns:
        bool: animal detection status
    """
    return __read_status_file()[0]

def get_automatic_watering_status() -> bool:
    """
    Returns status of automatic watering system
    Args:
        None
    Returns:
        bool: automatic watering status
    """
    return __read_status_file()[1]

def set_animal_detection_status(animal_status: bool):
    """
    Set status of animal detection (enabled/disabled)
    Args:
        bool: status to set animal detection
    Returns:
        None
    """
    watering_status = get_automatic_watering_status()
    __write_status_file((animal_status, watering_status))

def set_automatic_watering_status(watering_status: bool):
    """
    Set status of automatic watering (enabled/disabled)
    Args:
        bool: status to set automatic watering
    Returns:
        None
    """
    animal_status = get_animal_detection_status()
    __write_status_file((animal_status, watering_status))

