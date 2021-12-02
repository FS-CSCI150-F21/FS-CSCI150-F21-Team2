from datetime import datetime

def log(message: str, end: str = '\n'):
    now = datetime.utcnow()
    print(f'[{now}]:{message}', end=end)

def get_cur_iso_timestamp_t():
    # Get ISO timestamp with T instead of space
    timestamp = str(datetime.utcnow())
    timestamp_t = timestamp[:10] + 'T' + timestamp[11:]
    return timestamp_t