import sensors.digitaldevice


class Solenoid(sensors.digitaldevice.DigitalDevice):
    def get_solenoid_status(self):
        return self.status
