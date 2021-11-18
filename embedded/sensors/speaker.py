import digitaldevice


class Speaker(digitaldevice.DigitalDevice):
    def get_speaker_status(self):
        return self.status

    def play_sound_status(self,_list):
        return self.output_pattern(list_pattern=_list)