import board
import time
from threading import Lock, Thread
import sensors.solenoid_sensor as Sol
import sensors.soilmoisture as Soil
import sensors.flow_meter as Flow
import sensors.temperature as TempHum
import sensor_data.gather_sensor_data as get_data

# global variables needed for the process

__AirValue = 520;
__WaterValue = 260;
__intervals = (__AirValue - __WaterValue) / 3;


# The moisture thresholds are split into 3 levels of moisture Very wet, wet, and dry
def automatic_watering():
    garden_data = get_data.gather_all_sensor_data()
    soilMoistureValue = garden_data[4]
    if __WaterValue < soilMoistureValue < (__WaterValue + __intervals):
        garden_data[3].pin_off()
        print("Very Wet")
        leak_detection(garden_data[3], garden_data[2])
    elif (__WaterValue + __intervals) < soilMoistureValue < (__AirValue - __intervals):
        garden_data[3].pin_off()
        print("Wet")
    elif __AirValue > soilMoistureValue > (__AirValue - __intervals):
        garden_data[3].pin_on()
        print("Dry")
    time.sleep(500)


def leak_detection(solenoid: Sol, flow_rate):
    if solenoid().get_solenoid_status() == False and flow_rate() > 0:
        print("Potential water leak detected")
        warn()

def warn(case):
    pass
