import board
import time
from threading import Lock, Thread
import sensors.solenoid_sensor as Sol
import sensors.soilmoisture as Soil
import sensors.flow_meter as Flow
import sensors.temperature as TempHum
import sensor_data.gather_sensor_data as get_data

# global variables needed for the process

__DryValue = 520;
__WetValue = 260;
__Threshold = (__DryValue - __WetValue) / 3


# The moisture thresholds are split into 3 levels of moisture Very wet, wet, and dry
def automatic_watering():
    garden_data = get_data.gather_all_sensor_data()
    soilMoistureValue = garden_data[4]
    if __WetValue < soilMoistureValue < (__WetValue + __Threshold):
        garden_data[3].pin_off()
        print("Very Wet")
        leak_detection(garden_data[3], garden_data[2])
    elif (__WetValue + __Threshold) < soilMoistureValue < (__DryValue - __Threshold):
        garden_data[3].pin_off()
        print("Wet")
    elif __DryValue > soilMoistureValue > (__DryValue - __Threshold):
        garden_data[3].pin_on()
        print("Dry")
    time.sleep(5000)


def leak_detection(solenoid: Sol, flow_rate):
    if solenoid().get_solenoid_status() == False and flow_rate() > 0:
        print("Potential water leak detected")
        warn()


def warn(case):
    pass
