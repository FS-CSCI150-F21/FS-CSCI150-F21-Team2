import time
import board
import digitalio
from threading import Thread, Lock

mutex = Lock()

Speaker = digitalio.DigitalInOut(board.D2)  # map the light to GPIO 2 on the rpi (pin 13)
Speaker.direction = digitalio.Direction.OUTPUT  # set gpio as a digital output


def play_sound_pattern(list_pattern, lock):
    lock.acquire()
    timeout = time.time() + 60 * 5  # 5 minutes from now

    pattern_index = 0

    while True:  # run through
        if pattern_index > len(list_pattern):
            pattern_index = 0

        Speaker.value = True
        time.sleep(list_pattern[pattern_index])
        Speaker.value = False
        pattern_index += 1
        time.sleep(list_pattern[pattern_index])
        pattern_index += 1
        if time.time() > timeout:
            break

    lock.release()


def speaker_status():
    pass
