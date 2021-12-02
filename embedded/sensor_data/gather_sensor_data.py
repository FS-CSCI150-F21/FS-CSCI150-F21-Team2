import time
from threading import Lock

import sensors.solenoid_sensor as Sol
import sensors.soilmoisture as Soil
import sensors.flow_meter as Flow
import sensors.temperature as TempHum
from utils.logging import log, get_cur_iso_timestamp_t
import server.json_bodies as body
import server.connection as sc


def gather_all_sensor_data():
    Lock.acquire()
    log('Gathering data...')
    # Declare sensors needed, note the pins must be exact on all around code base for each physical sensor.
    # Cannot assign different pins to device already connected to another pin
    Solenoid = Sol.Solenoid("WaterValve", "OUT", 17)
    FlowMeter = Flow.FlowMeter("FlowMeter", 1)
    MoistureSensor = Soil.SoilMoistureSensor("SoilMoisture", 0)
    TempHumSensor = TempHum.TemperatureHumiditySensor("TempHum")

    _, uuid = sc.get_registration()
    timestamp = get_cur_iso_timestamp_t()
    CurGardenData = body.Data(gardenId=uuid,
                                timestamp=timestamp,
                                humidity=TempHumSensor.dht.humidity,
                                soilmoisture=MoistureSensor.read_analog_data(),
                                temperature=TempHumSensor.dht.temperature,
                                waterflow=FlowMeter.read_analog_data(),
                                wateractive=Solenoid.get_solenoid_status())

    # data = [temp_hum.dht.temperature, temp_hum.dht.humidity, flow_meter.read_analog_data,
    #         solenoid_stat, moisture.read_analog_data]
    Lock.release()
    log('Finished gathering data.')
    return CurGardenData


def leak_detection(solenoid: Sol, flow_rate):
    if solenoid().get_solenoid_status() == False and flow_rate() > 0:
        log("Potential water leak detected")


# def to_server():
#     while True:
#         print("Gathering data")
#         Lock().acquire()
#         data = gather_all_sensor_data()
#         send_data = DataRequest(data[0], data[1], data[2], data[3].get_device_status(), data[4])
#         print("Data acquired:", send_data.__dict__)
#         Lock().release()
#         time.sleep(5000)