class PiRegistration:
    def __init__(self, username, piId):
        self.username = username
        self.piId = piId

class Warning:
    def __init__(self, garden_id, timestamp, type):
        self.garden_id = garden_id
        self.timestamp = timestamp
        self.type = type