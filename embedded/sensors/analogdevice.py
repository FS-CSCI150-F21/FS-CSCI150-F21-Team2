import board
import busio
import adafruit_ads1x15.ads1115 as ADS
from adafruit_ads1x15.analog_in import AnalogIn
from threading import Thread, Lock


class AnalogDevice():
    __i2c = busio.I2C(board.SCL, board.SDA)
    __ads = ADS.ADS1115(__i2c)
    __occupied = None

    def __init__(self, channel, pin):
        if AnalogDevice.__occupied is not None and AnalogDevice.__occupied[pin]:
            raise ValueError("Pin is already assigned")

        self.channel = AnalogIn(AnalogDevice.__ads, ADS.P0)

    def read_soil_moisture(self):
        return self.channel.value


mutex.release()
