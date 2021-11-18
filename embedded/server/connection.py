import time
import requests
import json
from random import seed, randint
import os

from utils.logging import log
from utils.interaction import get_yn_response
import server.json_bodies as body
from server.endpoints import Endpoint

__server_folder = os.path.normpath(os.path.dirname(__file__) + os.sep)
__registration_file = str(__server_folder + '/.registration')

# Registration prefixes
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
        code += chr(randint(65, 90))
        code += str(randint(0, 9))

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

def register(timeout: int = 300000):
    """
    Register raspberry pi with server
    Args:
        timeout: int (default = 300000)
            Timeout for registration of raspberry pi in milliseconds
    Returns:
        None

    """

    timeout = float(timeout / 1000)
    
    # Check for pre-existing registration
    if os.path.exists(__registration_file):
        log('Parsing existing registation...')
        # get prior registration if it exists
        username, gardenID = get_registration()

        if username and gardenID:
            # let user decide whether or not to overwrite previous well-formed registration
            log(f'Previous registration found belonging to {username}, gardenID: {gardenID}!')
            log('Would you like to overwrite previous registration? (y/n):', end=' ')
            if not get_yn_response():
                return
        else:
            log('Malformed registration file, registration required...')
    else:
        log('No registration found...creating new registration.')

    # Get username to initiate pairing using pairing code        
    log('Please enter your username:', end=' ')
    username = input()
    pairing_code = generate_pairing_code()
    log(f'Your pairing code is [{pairing_code}], you have {timeout/60} minutes before it expires!')

    # Generate POST request body and send post request
    registration_body = body.PiRegistration(username, pairing_code).__dict__
    uuid = requests.post(url=Endpoint.REGISTRATION_ENDPOINT, json=registration_body)
    gardenID = uuid.content.decode('utf-8')
    
    # Write new credential to registration file
    with open(__registration_file, 'w') as FILE:
        FILE.write(f'{__username_pref}{username}\n')
        FILE.write(f'{__gardenID_pref}{gardenID}')

    log(f'Pi registered under ID: {gardenID} to username {username}!')


