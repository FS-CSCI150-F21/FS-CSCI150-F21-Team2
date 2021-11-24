import sensors.analogdevice
import sensors.digitaldevice
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
    solenoid_stat = Sol.Solenoid()
    flow_meter = Flow.FlowMeter()
    moisture = Soil.SoilMoistureSensor()
    temp_hum = TempHum.TemperatureHumiditySensor()


    #need to seperate temp and hum here

# global objects
if __name__ == "__main__":
    pass