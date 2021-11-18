import time
import board
import digitalio
from threading import Thread, Lock


class Speaker:
    buzzer = None

    """ This the pin-out for RPI Zero W
    J8:
       3V3  (1) (2)  5V    
     GPIO2  (3) (4)  5V    
     GPIO3  (5) (6)  GND   
     GPIO4  (7) (8)  GPIO14
       GND  (9) (10) GPIO15
    GPIO17 (11) (12) GPIO18
    GPIO27 (13) (14) GND   
    GPIO22 (15) (16) GPIO23
       3V3 (17) (18) GPIO24
    GPIO10 (19) (20) GND   
     GPIO9 (21) (22) GPIO25
    GPIO11 (23) (24) GPIO8 
       GND (25) (26) GPIO7 
     GPIO0 (27) (28) GPIO1 
     GPIO5 (29) (30) GND   
     GPIO6 (31) (32) GPIO12
    GPIO13 (33) (34) GND   
    GPIO19 (35) (36) GPIO16
    GPIO26 (37) (38) GPIO20
       GND (39) (40) GPIO21
    """

    def __init__(self, device_id, direction, pin):
        self.id = device_id
        self.direction = direction
        self.pin = pin

        if pin == 17:  # check pin-out for board
            Speaker.buzzer = digitalio.DigitalInOut(board.D17)  # map the light to GPIO 17 on the rpi
        elif pin == 27:
            Speaker.buzzer = digitalio.DigitalInOut(board.D27)  # map the light to GPIO 27 on the rpi
        elif pin == 22:
            Speaker.buzzer = digitalio.DigitalInOut(board.D22)  # map the light to GPIO 22 on the rpi
        elif pin == 10:
            Speaker.buzzer = digitalio.DigitalInOut(board.D10)  # map the light to GPIO 10 on the rpi
        elif pin == 9:
            Speaker.buzzer = digitalio.DigitalInOut(board.D9)  # map the light to GPIO 9 on the rpi
        elif pin == 11:
            Speaker.buzzer = digitalio.DigitalInOut(board.D11)  # map the light to GPIO 11 on the rpi
        elif pin == 5:
            Speaker.buzzer = digitalio.DigitalInOut(board.D5)  # map the light to GPIO 10 on the rpi
        elif pin == 6:
            Speaker.buzzer = digitalio.DigitalInOut(board.D6)  # map the light to GPIO 9 on the rpi
        elif pin == 19:
            Speaker.buzzer = digitalio.DigitalInOut(board.D19)  # map the light to GPIO 11 on the rpi
        elif pin == 26:
            Speaker.buzzer = digitalio.DigitalInOut(board.D26)  # map the light to GPIO 10 on the rpi
        elif pin == 23:
            Speaker.buzzer = digitalio.DigitalInOut(board.D23)  # map the light to GPIO 9 on the rpi
        elif pin == 24:
            Speaker.buzzer = digitalio.DigitalInOut(board.D24)  # map the light to GPIO 11 on the rpi
        elif pin == 25:
            Speaker.buzzer = digitalio.DigitalInOut(board.D25)  # map the light to GPIO 10 on the rpi
        elif pin == 8:
            Speaker.buzzer = digitalio.DigitalInOut(board.D8)  # map the light to GPIO 9 on the rpi
        elif pin == 7:
            Speaker.buzzer = digitalio.DigitalInOut(board.D7)  # map the light to GPIO 11 on the rpi
        elif pin == 16:
            Speaker.buzzer = digitalio.DigitalInOut(board.D16)  # map the light to GPIO 11 on the rpi

        status = False

    def __io_direction__(self):
        if self.direction == 'OUT':
            Speaker.buzzer.direction = digitalio.Direction.OUTPUT  # set gpio as a digital output
        elif self.direction == 'IN':
            Speaker.buzzer.direction = digitalio.Direction.INPUT  # set gpio as a digital output
        else:
            raise ValueError("Invalid IO Direction")

    @staticmethod
    def play_sound_pattern(list_pattern):

        Lock().acquire()
        timeout = time.time() + 60 * 5  # 5 minutes from now

        pattern_index = 0

        while True:  # run through
            if pattern_index > len(list_pattern):
                pass

            Speaker.buzzer.value = True
            time.sleep(list_pattern[pattern_index])
            Speaker.buzzer.value = False
            pattern_index += 1
            time.sleep(list_pattern[pattern_index])
            pattern_index += 1
            if time.time() > timeout:
                break

        Lock().release()

    @staticmethod
    def __new_analog_device__():
        pass

    def __device_status__(self):
        pass
