package com.smrtgrdyn.smrtgrdyn.Garden.Registration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.rmi.server.UID;
import java.util.UUID;

@Entity
public class GardenRegistrationRequest {

    @Id
    private String piId;

    private String username;
    private UUID gardenId;

    public GardenRegistrationRequest(String piId, String username, UUID gardenId) {
        this.piId = piId;
        this.username = username;
        this.gardenId = gardenId;
    }

    public UUID getGardenId() {
        return gardenId;
    }

    public void setGardenId(UUID gardenId) {
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
