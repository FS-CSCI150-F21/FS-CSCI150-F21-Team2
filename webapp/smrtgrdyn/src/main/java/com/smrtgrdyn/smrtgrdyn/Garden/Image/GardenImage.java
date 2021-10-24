package com.smrtgrdyn.smrtgrdyn.Garden.Image;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

//Garden Image table
@Entity
public class GardenImage {

    @Id
    private UUID gardenId;

    private java.sql.Date timestamp;
    private String filepath;


    public GardenImage(UUID gardenId, java.sql.Date timestamp, String filepath) {
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

    public java.sql.Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(java.sql.Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
