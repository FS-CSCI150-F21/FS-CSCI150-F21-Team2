import time
import board
import digitalio
from threading import Thread, Lock


mutex = Lock()

Light_12V = digitalio.DigitalInOut(board.D2)  # map the light to GPIO 2 on the rpi (pin 13)
Light_12V.direction = digitalio.Direction.OUTPUT  # set gpio as a digital output

mutex.acquire()


def warning1(on_time, off_time):

    timeout = time.time() + 60 * 5  # 5 minutes from now

    while True:  # run through
        Light_12V.value = True
        time.sleep(on_time)
        Light_12V.value = False
        time.sleep(off_time)
        if time.time() > timeout:
            break


mutex.release()


