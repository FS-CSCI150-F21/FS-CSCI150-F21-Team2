import board
import busio
import adafruit_ads1x15.ads1115 as ADS
from adafruit_ads1x15.analog_in import AnalogIn
from threading import Thread, Lock


i2c = busio.I2C(board.SCL, board.SDA)

mutex = Lock()
ads = ADS.ADS1115(i2c)
mutex.acquire()


def read_soil_moisture():
    channel = AnalogIn(ads, ADS.P0)
    return channel.value


def read_temperature_humidity():
    channel = AnalogIn(ads, ADS.P1)
    return channel.value


mutex.release()

