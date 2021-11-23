import board
import busio
import adafruit_ads1x15.ads1115 as ADS
from adafruit_ads1x15.analog_in import AnalogIn


class AnalogDevice():
    __i2c = busio.I2C(board.SCL, board.SDA)
    __ads = ADS.ADS1115(__i2c)
    __occupied = [None] * 4

    def __init__(self, device_id, pin):
        self.pin = pin
        self.device_id = device_id

        if AnalogDevice.__occupied is not None and AnalogDevice.__occupied[pin]:
            raise ValueError("Pin is already assigned")

        if self.pin == 0:
            AnalogDevice.__occupied[self.pin] = True
            self.channel = AnalogIn(AnalogDevice.__ads, ADS.P0)
        elif self.pin == 1:
            AnalogDevice.__occupied[self.pin] = True
            self.channel = AnalogIn(AnalogDevice.__ads, ADS.P1)
        elif self.pin == 2:
            AnalogDevice.__occupied[self.pin] = True
            self.channel = AnalogIn(AnalogDevice.__ads, ADS.P2)
        elif self.pin == 3:
            AnalogDevice.__occupied[self.pin] = True
            self.channel = AnalogIn(AnalogDevice.__ads, ADS.P3)
        else:
            raise ValueError("Invalid pin in use")  # user entered the incorrect pin

    def read_analog_data(self):
        return self.channel.value


mutex.release()
