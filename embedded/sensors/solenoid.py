import digitaldevice


class Solenoid(digitaldevice.DigitalDevice):
    def get_solenoid_status(self):
        return self.status
