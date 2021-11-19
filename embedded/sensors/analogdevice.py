import sensors.digitaldevice

analog_occupied = None


class AnalogToDigDevice(sensors.digitaldevice.DigitalDevice):
    def __init__(self, device_id, direction, pin, adc_pin):
        super().__init__(device_id, direction, pin)
        self.adc_pin = adc_pin;
