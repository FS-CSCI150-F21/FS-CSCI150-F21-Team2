package com.smrtgrdyn.smrtgrdyn.Garden.Image;


import java.io.Serializable;

import java.sql.Timestamp;
import java.util.Objects;


public class GardenImageId implements Serializable {

    private String gardenId;
    private Timestamp timestamp;

    public GardenImageId() {
    }

    public GardenImageId(String gardenId, Timestamp timestamp) {
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
        GardenImageId that = (GardenImageId) o;
        return gardenId.equals(that.gardenId) && timestamp.equals(that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gardenId, timestamp);
    }
}

