package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "garden_sensor_data")
@IdClass(GardenSensorDataId.class)
public class GardenSensorData {
/*
    {
        "gardenid" : "cb6061dc-6d01-436b-b5aa-09d1a758c8cb", // generated from the server, stored on the pi
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
    private String gardenId;

    @Id
    private Timestamp timestamp;


    @Column(nullable = true)
    private boolean waterActive;
    @Column(nullable = true)
    private double temperature;
    @Column(nullable = true)
    private double soilMoisture;
    @Column(nullable = true)
    private double waterFlow;
    @Column(nullable = true)
    private double humidity;

    public GardenSensorData(String gardenId, Timestamp timestamp, boolean waterActive, double temperature, double soilMoisture, double waterFlow, double humidity) {
        this.gardenId = gardenId;
        this.timestamp = timestamp;
        this.waterActive = waterActive;
        this.temperature = temperature;
        this.soilMoisture = soilMoisture;
        this.waterFlow = waterFlow;
        this.humidity = humidity;
    }

    public GardenSensorData() {
    }

    public String getGardenId() {
        return gardenId;
    }

    public void setGardenId(String gardenId) {
        this.gardenId = gardenId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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

    @Override
    public String toString() {
        return "GardenSensorData{" +
                "gardenId=" + gardenId +
                ", timestamp='" + timestamp.toString() + '\'' +
                ", waterActive=" + waterActive +
                ", temperature=" + temperature +
                ", soilMoisture=" + soilMoisture +
                ", waterFlow=" + waterFlow +
                ", humidity=" + humidity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GardenSensorData that = (GardenSensorData) o;
        return waterActive == that.waterActive && Double.compare(that.temperature, temperature) == 0 && Double.compare(that.soilMoisture, soilMoisture) == 0 && Double.compare(that.waterFlow, waterFlow) == 0 && Double.compare(that.humidity, humidity) == 0 && gardenId.equals(that.gardenId) && timestamp.equals(that.timestamp);
    }


}
