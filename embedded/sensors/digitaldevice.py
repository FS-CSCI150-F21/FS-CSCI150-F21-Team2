import time
import board
import digitalio
from threading import Lock


class DigitalDevice:
    __digital_occupied = [None] * 27

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
        self.device_id = device_id
        self.direction = direction
        self.pin = pin
        self.board_dio = None
        self.status = False

        # Note: not all pins are available as they are reserved for i2c and other protocols
        # check digital pin to see if it is occupied
        if DigitalDevice.__digital_occupied is not None and DigitalDevice.__digital_occupied[self.pin]:
            raise ValueError("Pin is already assigned")

        if self.pin == 17:  # check pin-out for board
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D17)  # map the light to GPIO 17 on the rpi
            self.__io_direction__()
        elif self.pin == 27:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D27)  # map the light to GPIO 27 on the rpi
            self.__io_direction__()
        elif self.pin == 22:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D22)  # map the light to GPIO 22 on the rpi
            self.__io_direction__()
        elif self.pin == 10:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D10)  # map the light to GPIO 10 on the rpi
            self.__io_direction__()
        elif self.pin == 9:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D9)  # map the light to GPIO 9 on the rpi
            self.__io_direction__()
        elif self.pin == 11:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D11)  # map the light to GPIO 11 on the rpi
            self.__io_direction__()
        elif self.pin == 5:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D5)  # map the light to GPIO 5 on the rpi
            self.__io_direction__()
        elif self.pin == 6:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D6)  # map the light to GPIO 6 on the rpi
            self.__io_direction__()
        elif self.pin == 19:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D19)  # map the light to GPIO 19 on the rpi
            self.__io_direction__()
        elif self.pin == 26:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D26)  # map the light to GPIO 26 on the rpi
            self.__io_direction__()
        elif self.pin == 23:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D23)  # map the light to GPIO 23 on the rpi
            self.__io_direction__()
        elif self.pin == 24:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D24)  # map the light to GPIO 24 on the rpi
            self.__io_direction__()
        elif self.pin == 25:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D25)  # map the light to GPIO 25 on the rpi
            self.__io_direction__()
        elif self.pin == 8:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D8)  # map the light to GPIO 8 on the rpi
            self.__io_direction__()
        elif self.pin == 7:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D7)  # map the light to GPIO 7 on the rpi
            self.__io_direction__()
        elif self.pin == 16:
            DigitalDevice.__digital_occupied[self.pin] = True
            self.board_dio = digitalio.DigitalInOut(board.D16)  # map the light to GPIO 16 on the rpi
            self.__io_direction__()
        else:
            raise ValueError("Invalid pin in use")  # user entered the incorrect pin

        status = False

    def __io_direction__(self):
        if self.direction == 'OUT':
            self.board_dio.direction = digitalio.Direction.OUTPUT  # set gpio as a digital output
        elif self.direction == 'IN':
            self.board_dio.direction = digitalio.Direction.INPUT  # set gpio as a digital input
        else:
            raise ValueError("Invalid IO Direction")

    def output_pattern(self, list_pattern):

        Lock().acquire()
        if self.direction == "IN":
            raise ValueError("Can't set input pin to output value")
        timeout = time.time() + 60 * 5  # 5 minutes from now
        pattern_index = 0
        self.status = True

        while True:  # run through the whole list and restart until time has passed
            if pattern_index > len(list_pattern):
                pattern_index = 0

            self.board_dio.value = True
            time.sleep(list_pattern[pattern_index])
            self.board_dio.value = False
            pattern_index += 1
            time.sleep(list_pattern[pattern_index])
            pattern_index += 1
            if time.time() > timeout:
                self.status = False
                break

        Lock().release()

    def read_input(self):  # read data from a digital input
        Lock().acquire()
        if self.direction == "OUT":
            raise ValueError("Pin is set to output. Reading is invalid")
        Lock().release()
        return self.board_dio.value

    def get_device_status(self):
        return self.status

    def pin_off(self): # manually turn output pin off
        Lock().acquire()
        if self.direction == "IN":
            raise ValueError("Can't set input pin to output value")
        self.status = False
        self.board_dio.value = False
        Lock().release()

    def pin_on(self): # manually turn output pin on
        Lock().acquire()
        if self.direction == "IN":
            raise ValueError("Can't set input pin to output value")
        self.status = False
        self.board_dio.value = False
        Lock().release()

    def get_device_id(self):
        return self.device_id
