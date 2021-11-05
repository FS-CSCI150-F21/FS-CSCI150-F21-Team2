package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class GardenSensorDataId implements Serializable {

    private String gardenId;
    private Timestamp timestamp;

    public GardenSensorDataId() {
    }

    public GardenSensorDataId(String gardenId, Timestamp timestamp) {
        this.gardenId = gardenId;
        this.timestamp = timestamp;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GardenSensorDataId that = (GardenSensorDataId) o;
        return gardenId.equals(that.gardenId) && timestamp.equals(that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gardenId, timestamp);
    }
}
