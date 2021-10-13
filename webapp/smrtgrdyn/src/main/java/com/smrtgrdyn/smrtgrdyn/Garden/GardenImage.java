package com.smrtgrdyn.smrtgrdyn.Garden;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

//Garden Image table
@Entity
public class GardenImage {

    @Id
    UUID gardenId;

    String timestamp;
    String filepath;

    public GardenImage(UUID gardenId, String timestamp, String filepath) {
        this.gardenId = gardenId;
        this.timestamp = timestamp;
        this.filepath = filepath;
    }

    public GardenImage() {
    }

    public UUID getGardenId() {
        return gardenId;
    }

    public void setGardenId(UUID gardenId) {
        this.gardenId = gardenId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
