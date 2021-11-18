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

def get_registration():
    """
    Check registration file for credentials
    Agrs:
        None
    Returns:
        (str, str): Returns username and garden id in a tuple, returns (None, None) if either are malformed
    """

    # Read in registration file
    imported_reg: any
    with open(__registration_file, 'r') as FILE:
            imported_reg = FILE.read().splitlines()
    
    # Parse registration file
    username = None
    gardenID = None
    for line in imported_reg:
        if __username_pref in line:
            username = line.lstrip(__username_pref)
        elif __gardenID_pref in line:
            gardenID = line.lstrip(__gardenID_pref)

    # Return username and gardenID only if they are well-formed
    if not (username and gardenID):
        return (None, None)
    else:
        return (username, gardenID) 




