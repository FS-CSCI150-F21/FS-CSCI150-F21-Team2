import time
from utils.logging import log
from utils.interaction import get_yn_response
from random import seed, randint
import os

# Global variables for file
__server_folder = os.path.normpath(os.path.dirname(__file__) + os.sep)
__registration_file = str(__server_folder + '.registration')

__username_pref = 'username='
__gardenID_pref = 'gardenID='

def generate_pairing_code() -> str:
    """
    Generates random pairing code to allow registration of RPi
    Args:
        None:
    Returns
        str: Pairing code
    """
    code = ''
    seed(time.time())
    for i in range(3):
        code += chr(randint() % 26 + 65)
        code += str(randint() % 10)

    return code



