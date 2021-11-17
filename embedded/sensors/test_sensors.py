import time
import board
import digitalio

print("hello blinky!")

led = digitalio.DigitalInOut(board.D2)
led.direction = digitalio.Direction.OUTPUT

while True:
    led.value = True
    time.sleep(10)
    led.value = False
    time.sleep(5)