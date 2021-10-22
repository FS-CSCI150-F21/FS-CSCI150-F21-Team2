import time
import board
import digitalio
from threading import Thread, Lock

mutex = Lock()

WaringLight = digitalio.DigitalInOut(board.D2) #map the light to GPIO 2 on the rpi (pin 17)
WaringLight.direction = digitalio.Direction.OUTPUT #set gpio as a digital output

def warning1(ontime, offtime)
    mutex.aquire()
    timeout = time.time() + 60*5   # 5 minutes from now
    
    while True: #run through 
        WaringLight.value = True
        time.sleep(ontime)
        WaringLight.value = False
        time.sleep(offtime)
        if time.time() > timeout:
            break

    mutex.release()