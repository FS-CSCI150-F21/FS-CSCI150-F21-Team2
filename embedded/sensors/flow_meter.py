import sensors.analogdevice


class FlowMeter(sensors.analogdevice.AnalogDevice):
    def get_flow_rate(self):
        return self.read_analog_data()
