class PiRegistration:
    def __init__(self, username, piId):
        self.username = username
        self.piId = piId

class Warning:
    def __init__(self, gardenId, timestamp, type, message = ''):
        self.gardenId = gardenId
        self.timestamp = timestamp
        self.type = type
        self.message = message

class Image:
    def __init__(self, gardenId, timestamp, image):
        self.gardenId = gardenId
        self.timestamp = timestamp
        self.image = image

class Data:
    def __init__(self, gardenId: str, timestamp: str, humidity: str,
                soilmoisture: float, temperature: float, waterflow: float, 
                wateractive: bool):
        self.gardenId = gardenId
        self.timestamp = timestamp
        self.humidity = humidity
        self.soilMoisture = soilmoisture
        self.temperature = temperature
        self.waterFlow = waterflow
        self.waterActive = wateractive

class ServerRequest:
    def __init__(self, gardenId: str, action: str):
        self.gardenId = gardenId
        self.action = int(action)
