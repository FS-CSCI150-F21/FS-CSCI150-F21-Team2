package com.smrtgrdyn.smrtgrdyn.Garden.Image;

import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
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
    private Timestamp timestamp;

    @Nullable
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

    @Override
    public String toString() {
        return "GardenImage{" +
                "gardenId=" + gardenId +
                ", timestamp=" + timestamp +
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

    @Override
    public int hashCode() {
        return Objects.hash(gardenId, timestamp, filepath);
    }
}
