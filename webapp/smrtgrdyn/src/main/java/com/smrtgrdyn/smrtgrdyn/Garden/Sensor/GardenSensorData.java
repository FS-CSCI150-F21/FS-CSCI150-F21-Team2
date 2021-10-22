package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;

import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name = "garden_sensor_data")
public class GardenSensorData {
/*
    {
        "gardenid" : "sfdds-fwgw-egv-wgeq", // generated from the server, stored on the pi
        "wateractive" : false,
        "temperature" : 45.3,
        "soilmoisture" : 32.1,
        "waterflow" : 43.1,
        "humidity" : 7.0,
        "timestamp" : "9082304823048"
    }

    smrtgrdyn.com/gardenstatus {json}
*/

    @Id
    UUID gardenId;

    @NotBlank
    String timestamp;

    @Nullable
    boolean waterActive;
    @Nullable
    double temperature;
    @Nullable
    double soilMoisture;
    @Nullable
    double waterFlow;
    @Nullable
    double humidity;


    public GardenSensorData(UUID gardenId, boolean waterActive, double temperature, double soilMoisture, double waterFlow, double phBalance, String timestamp) {
        this.gardenId = gardenId;
        this.waterActive = waterActive;
        this.temperature = temperature;
        this.soilMoisture = soilMoisture;
        this.waterFlow = waterFlow;
        this.humidity = phBalance;
        this.timestamp = timestamp;
    }

    public GardenSensorData() {
    }

    public UUID getGardenId() {
        return gardenId;
    }

    public void setGardenId(UUID gardenId) {
        this.gardenId = gardenId;
    }

    public boolean isWaterActive() {
        return waterActive;
    }

    public void setWaterActive(boolean waterActive) {
        this.waterActive = waterActive;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(double soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public double getWaterFlow() {
        return waterFlow;
    }

    public void setWaterFlow(double waterFlow) {
        this.waterFlow = waterFlow;
    }
    
    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "GardenSensorData{" +
                "gardenId=" + gardenId +
                ", waterActive=" + waterActive +
                ", temperature=" + temperature +
                ", soilMoisture=" + soilMoisture +
                ", waterFlow=" + waterFlow +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
