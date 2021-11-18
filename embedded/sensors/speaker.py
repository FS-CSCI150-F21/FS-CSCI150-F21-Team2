import time
import board
import digitalio
from threading import Thread, Lock


mutex = Lock()

Speaker = digitalio.DigitalInOut(board.D2)  # map the light to GPIO 2 on the rpi (pin 13)
Speaker.direction = digitalio.Direction.OUTPUT  # set gpio as a digital output

mutex.acquire()


def warning1(pattern):

    timeout = time.time() + 60 * 5  # 5 minutes from now

    count = 0

    while True:  # run through
        if count > len(pattern):
            count = 0

        Speaker.value = True
        time.sleep(pattern[count])
        Speaker.value = False
        count += 1
        time.sleep(pattern[count])
        count += 1
        if time.time() > timeout:
            break


mutex.release()


