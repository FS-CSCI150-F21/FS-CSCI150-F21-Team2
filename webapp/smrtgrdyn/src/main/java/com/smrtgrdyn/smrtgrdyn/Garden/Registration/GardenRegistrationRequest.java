package com.smrtgrdyn.smrtgrdyn.Garden.Registration;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GardenRegistrationRequest {

    @Id
    private String piId;

    private String username;
    private String gardenId;

    public GardenRegistrationRequest(String piId, String username, String gardenId) {
        this.piId = piId;
        this.username = username;
        this.gardenId = gardenId;
    }

    public String getGardenId() {
        return gardenId;
    }

    public void setGardenId(String gardenId) {
        this.gardenId = gardenId;
    }

    public GardenRegistrationRequest() {
    }

    public String getPiId() {
        return piId;
    }

    public void setPiId(String piId) {
        this.piId = piId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "GardenRegistrationRequest{" +
                "piId='" + piId + '\'' +
                ", username='" + username + '\'' +
                ", gardenId=" + gardenId +
                '}';
    }
}
