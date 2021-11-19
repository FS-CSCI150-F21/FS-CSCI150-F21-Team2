package com.smrtgrdyn.smrtgrdyn.Garden.GardenName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GardenName {

    @Id
    private String gardenId;
    private String gardenName;
    private String username;

    public GardenName() {
    }

    public GardenName(String gardenId, String gardenName, String username) {
        this.gardenId = gardenId;
        this.gardenName = gardenName;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGardenId() {
        return gardenId;
    }

    public void setGardenId(String gardenId) {
        this.gardenId = gardenId;
    }

    @Override
    public String toString() {
        return "GardenName{" +
                "gardenId='" + gardenId + '\'' +
                ", gardenName='" + gardenName + '\'' +
                ", user='" + username + '\'' +
                '}';
    }

    public String getGardenName() {
        return gardenName;
    }

    public void setGardenName(String gardenName) {
        this.gardenName = gardenName;
    }
}
