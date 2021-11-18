import time
import digitaldevice
from threading import Lock, Thread


class Light12v(digitaldevice.DigitalDevice):
    def get_light_status(self):
        return self.status
