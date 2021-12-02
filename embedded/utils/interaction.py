from utils.logging import log

def get_yn_response() -> bool:
    """
    Gets y/n response from user and returns corresponding bool
    """
    response = ''
    while not response:
        response = input()
        if response == 'y':
            return True
        if response == 'n':
            return False
        response = ''
        log('Please enter y/n:', end=' ')