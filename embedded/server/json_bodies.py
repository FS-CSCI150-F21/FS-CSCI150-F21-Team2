class PiRegistration:
    def __init__(self, username, piId):
        self.username = username
        self.piId = piId

class Warning:
    def __init__(self, gardenId, timestamp, type, message = ''):
        self.gardenId = gardenId
        self.timestamp = int(timestamp)
        self.type = type
        self.message = message

class Image:
    def __init__(self, gardenId, timestamp):
        self.gardenId = gardenId
        self.timestamp = timestamp