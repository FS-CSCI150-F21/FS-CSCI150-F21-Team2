import time
import adafruit_dht
import board


def __test__dht():

    dht_test_var = TemperatureHumiditySensor("Temp_Hum")

    while True:
        try:
            temperature = dht_test_var.dht.temperature
            humidity = dht_test_var.dht.humidity
            # Print what we got to the REPL
            print("Temp: {:.1f} *C \t Humidity: {}%".format(temperature, humidity))
        except RuntimeError as e:
            # Reading doesn't always work! Just print error and we'll try again
            print("Reading from DHT failure: ", e.args)

        time.sleep(1)


class TemperatureHumiditySensor:
    dht = None

    def __init__(self, device_id):
        self.device_id = device_id
        TemperatureHumiditySensor.__set_dht22()

    @staticmethod
    def __set_dht22():
        TemperatureHumiditySensor.dht = adafruit_dht.DHT22(board.D2)
