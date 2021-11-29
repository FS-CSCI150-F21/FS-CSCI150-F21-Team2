from datetime import datetime

def log(message: str, end: str = '\n'):
    now = datetime.utcnow()
    print(f'[{now}]:{message}', end=end)