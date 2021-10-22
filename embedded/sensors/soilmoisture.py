import board
import busio
i2c = busio.I2C(board.SCL, board.SDA)
import adafruit_ads1x15.ads1115 as ADS
from adafruit_ads1x15.analog_in import AnalogIn
from threading import Thread, Lock

mutex = Lock()
ads = ADS.ADS1115(i2c)

def read_soil_moisture()
    mutex.aquire()
    chan = AnalogIn(ads, ADS.P0)
    return chan.value
    mutex.release()