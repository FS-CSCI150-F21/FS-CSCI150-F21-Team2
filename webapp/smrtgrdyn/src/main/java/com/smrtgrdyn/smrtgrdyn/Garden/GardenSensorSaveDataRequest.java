package com.smrtgrdyn.smrtgrdyn.Garden;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GardenSensorSaveDataRequest {

    private final GardenSensorData gardenSensorData;

    public GardenSensorSaveDataRequest(
            @JsonProperty("garden-data") GardenSensorData gardenSensorData) {
        this.gardenSensorData = gardenSensorData;

    }

    public GardenSensorData getGardenSensorData(){
        return gardenSensorData;
    }

    @Override
    public String toString() {
        return "GardenSensorSaveData{" +
                "gardenSensorData=" + gardenSensorData +
                '}';
    }
}
