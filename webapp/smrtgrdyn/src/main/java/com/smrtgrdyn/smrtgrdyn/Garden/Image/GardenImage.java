package com.smrtgrdyn.smrtgrdyn.Garden.Image;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

//Garden Image table
@Entity
@Table(name = "garden_images")
@IdClass(GardenImageId.class)
public class GardenImage {

    @Id
    private UUID gardenId;
    @Id
    private Timestamp image_timestamp;

    @Column(nullable = true)
    private String filepath;


    public GardenImage(UUID gardenId, Timestamp image_timestamp, String filepath) {
        this.gardenId = gardenId;
        this.image_timestamp = image_timestamp;
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

    public Timestamp getImage_timestamp() {
        return image_timestamp;
    }

    public void setImage_timestamp(Timestamp image_timestamp) {
        this.image_timestamp = image_timestamp;
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
                ", image_timestamp=" + image_timestamp +
                ", filepath='" + filepath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GardenImage that = (GardenImage) o;
        return gardenId.equals(that.gardenId) && image_timestamp.equals(that.image_timestamp) && Objects.equals(filepath, that.filepath);
    }

}
