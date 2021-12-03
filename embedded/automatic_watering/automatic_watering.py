import board
import time
from threading import Lock, Thread
import sensors.solenoid_sensor as Sol
import sensors.soilmoisture as Soil
import sensors.flow_meter as Flow
import sensors.temperature as TempHum
import sensor_data.gather_sensor_data as get_data
from utils.logging import log
import utils.status as us

# global variables needed for the process
__DryValue = 520;
__WetValue = 260;
__Threshold = (__DryValue - __WetValue) / 3


# The moisture thresholds are split into 3 levels of moisture Very wet, wet, and dry
def automatic_watering_loop(update_freq: int = 30000, timeout: int = 600000):
    """
    Loop responsible for automatically watering garden

    Args:
        int: update_freq: how often to check garden soil conditions on milliseconds
        int: timeout: after how long to turn off automatic watering (0 for never)
    Returns:
        None
    """

    update_freq /= 1000
    timeout /= 1000
    Solenoid = Sol.Solenoid("WaterValve", "OUT", 17)

    while True:
        GardenData = get_data.gather_all_sensor_data()
        soil_moisture_value = GardenData.soilMoisture
        if __WetValue < soil_moisture_value < (__WetValue + __Threshold):
            Solenoid.pin_off()
            log("Garden soil conditions are very wet.")
        elif (__WetValue + __Threshold) < soil_moisture_value < (__DryValue - __Threshold):
            Solenoid.pin_off()
            log("Garden soil conditions are wet.")
        elif __DryValue > soil_moisture_value > (__DryValue - __Threshold):
            Solenoid.pin_on()
            log("Garden soil conditions are dry.")
        time.sleep(update_freq)  # wait 30 seconds before checking again
        watering_enabled = us.get_automatic_watering_status()
        if (time.time() > timeout and timeout > 0) or not watering_enabled:
            break