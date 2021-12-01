import time
from threading import Lock
import sensors.solenoid_sensor as Sol
import sensors.soilmoisture as Soil
import sensors.flow_meter as Flow
import sensors.temperature as TempHum


class DataRequest:
    def __init__(self, temp, humidity, flow_rate, water_active, soil_moisture):
        self.temp = temp
        self.humidity = humidity
        self.flow_rate = flow_rate
        self.water_active = water_active
        self.soil_moisture = soil_moisture


def gather_all_sensor_data():
    # Declare sensors needed, note the pins must be exact on all around code base for each physical sensor.
    # Cannot assign different pins to device already connected to another pin
    solenoid_stat = Sol.Solenoid("WaterValve", "OUT", 17)
    flow_meter = Flow.FlowMeter("FlowMeter", 1)
    moisture = Soil.SoilMoistureSensor("SoilMoisture", 0)
    temp_hum = TempHum.TemperatureHumiditySensor("TempHum")

    data = [temp_hum.dht.temperature, temp_hum.dht.humidity, flow_meter.read_analog_data,
            solenoid_stat.get_device_status(), moisture.read_analog_data]
    return data


def to_server():
    while True:
        print("Gathering data")
        Lock().acquire()
        data = gather_all_sensor_data()
        send_data = DataRequest(data[0], data[1], data[2], data[3], data[4])
        print("Data acquired:", send_data.__dict__)
        Lock().release()
        time.sleep(5000)

