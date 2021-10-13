package com.smrtgrdyn.smrtgrdyn.Garden;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class GardenSensorData {
/*
    {
        "gardenid" : "sfdds-fwgw-egv-wgeq", // generated from the server, stored on the pi
        "wateractive" : false,
        "temperature" : 45.3,
        "soilmoisture" : 32.1,
        "waterflow" : 43.1,
        "timestamp" : "9082304823048"
    }

    smrtgrdyn.com/gardenstatus {json}
*/

    @Id
    UUID gardenid;

    boolean wateractive;
    double temperature;
    double soilmoisture;
    double waterflow;
    String timestamp;

    public GardenSensorData(UUID gardenid, boolean wateractive, double temperature, double soilmoisture, double waterflow, String timestamp) {
        this.gardenid = gardenid;
        this.wateractive = wateractive;
        this.temperature = temperature;
        this.soilmoisture = soilmoisture;
        this.waterflow = waterflow;
        this.timestamp = timestamp;
    }

    public GardenSensorData() {
    }

    public UUID getGardenid() {
        return gardenid;
    }

    public void setGardenid(UUID gardenid) {
        this.gardenid = gardenid;
    }

    public boolean isWateractive() {
        return wateractive;
    }

    public void setWateractive(boolean wateractive) {
        this.wateractive = wateractive;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getSoilmoisture() {
        return soilmoisture;
    }

    public void setSoilmoisture(double soilmoisture) {
        this.soilmoisture = soilmoisture;
    }

    public double getWaterflow() {
        return waterflow;
    }

    public void setWaterflow(double waterflow) {
        this.waterflow = waterflow;
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
                "gardenid=" + gardenid +
                ", wateractive=" + wateractive +
                ", temperature=" + temperature +
                ", soilmoisture=" + soilmoisture +
                ", waterflow=" + waterflow +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
