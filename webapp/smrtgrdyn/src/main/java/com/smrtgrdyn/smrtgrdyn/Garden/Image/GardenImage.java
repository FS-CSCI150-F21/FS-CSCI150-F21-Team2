package com.smrtgrdyn.smrtgrdyn.Garden.Image;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


//Garden Image table
@Entity
@Table(name = "garden_images")
@IdClass(GardenImageId.class)
public class GardenImage {

    @Id
    private String gardenId;
    @Id
    private Timestamp timestamp;

    @Column(nullable = true)
    private String filepath;


    public GardenImage(String gardenId, Timestamp timestamp, String filepath) {
        this.gardenId = gardenId;
        this.timestamp = timestamp;
        this.filepath = filepath;
    }

    public GardenImage() {
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

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public String toString() {
        return "GardenImage{" +
                "gardenId=" + gardenId +
                ", image_timestamp=" + timestamp +
                ", filepath='" + filepath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GardenImage that = (GardenImage) o;
        return gardenId.equals(that.gardenId) && timestamp.equals(that.timestamp) && Objects.equals(filepath, that.filepath);
    }

}
