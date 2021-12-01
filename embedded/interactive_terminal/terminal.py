import os

import server.connection as sc
from utils.logging import log

def terminal_loop():
    while True:
        user_input = input()
        execute_user_command(user_input)

def execute_user_command(command: str):
    commands = [':help', ':register', ':quit']

    if command == ':help':
        log(f'Possible commands are: {commands}')
    elif command == ':register':
        sc.register()
    elif command == ':quit':
        log('Terminating program!')
        os._exit(0)
    else:
        log('Invalid command given!')

