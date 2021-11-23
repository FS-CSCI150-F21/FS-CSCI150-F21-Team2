import sensors.analogdevice


class TemperatureHumiditySensor(sensors.analogdevice.AnalogDevice):
    def get_temp_humidity(self):
        return self.read_analog_data()
