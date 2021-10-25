package com.smrtgrdyn.smrtgrdyn.Garden.Image;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.sql.Timestamp;
import java.util.UUID;

//Garden Image table
@Entity
@IdClass(GardenImageId.class)
public class GardenImage {

    @Id
    private UUID gardenId;

    private Timestamp timestamp;
    private String filepath;


    public GardenImage(UUID gardenId, Timestamp timestamp, String filepath) {
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
