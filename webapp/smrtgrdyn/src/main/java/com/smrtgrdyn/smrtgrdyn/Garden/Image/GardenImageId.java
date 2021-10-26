package com.smrtgrdyn.smrtgrdyn.Garden.Image;


import java.io.Serializable;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

public class GardenImageId implements Serializable {

    private UUID gardenId;
    private Timestamp image_timestamp;

    public GardenImageId() {
    }

    public GardenImageId(UUID gardenId, Timestamp image_timestamp) {
        this.gardenId = gardenId;
        this.image_timestamp = image_timestamp;
    }

    public UUID getGardenId() {
        return gardenId;
    }

    public void setGardenId(UUID gardenId) {
        this.gardenId = gardenId;
    }

    public Timestamp getImage_timestamp() {
        return image_timestamp;
    }

    public void setImage_timestamp(Timestamp image_timestamp) {
        this.image_timestamp = image_timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GardenImageId that = (GardenImageId) o;
        return gardenId.equals(that.gardenId) && image_timestamp.equals(that.image_timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gardenId, image_timestamp);
    }
}

