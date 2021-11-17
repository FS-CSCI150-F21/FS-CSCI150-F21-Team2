from datetime import datetime

def log(message: str):
    now = datetime.utcnow()
    print(f'[{now}]:{message}')