package com.smrtgrdyn.smrtgrdyn.Garden.Image;


import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class GardenImageId implements Serializable {

    private UUID gardenId;
    private String filepath;

    public GardenImageId() {
    }

    public GardenImageId(UUID gardenId, String filepath) {
        this.gardenId = gardenId;
        this.filepath = filepath;
    }

    public UUID getGardenId() {
        return gardenId;
    }

    public void setGardenId(UUID gardenId) {
        this.gardenId = gardenId;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GardenImageId that = (GardenImageId) o;
        return gardenId.equals(that.gardenId) && filepath.equals(that.filepath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gardenId, filepath);
    }
}
