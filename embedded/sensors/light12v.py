import sensors.digitaldevice


class Light12v(sensors.digitaldevice.DigitalDevice):
    def get_light_status(self):
        return self.status
