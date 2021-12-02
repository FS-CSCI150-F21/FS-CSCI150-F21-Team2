import sensors.analogdevice


class SoilMoistureSensor(sensors.analogdevice.AnalogDevice):
    def get_soil_moisture(self):
        return self.read_analog_data()
