import board
import time
from threading import Lock, Thread
import sensors.solenoid_sensor as Sol
import sensors.soilmoisture as Soil
import sensors.flow_meter as Flow
import sensors.temperature as TempHum

"""

const int AirValue = 520;   
const int WaterValue = 260;  
int intervals = (AirValue - WaterValue)/3;   
int soilMoistureValue = 0;
void setup() {
  Serial.begin(9600); // open serial port, set the baud rate to 9600 bps
}
void loop() {
soilMoistureValue = analogRead(A0);  //put Sensor insert into soil
if(soilMoistureValue > WaterValue && soilMoistureValue < (WaterValue + intervals)) { Serial.println("Very Wet"); } else if(soilMoistureValue > (WaterValue + intervals) && soilMoistureValue < (AirValue - intervals))
{
  Serial.println("Wet");
}
else if(soilMoistureValue < AirValue && soilMoistureValue > (AirValue - intervals))
{
  Serial.println("Dry");
}
delay(100);
}

"""

def automatic_watering():
    pass
