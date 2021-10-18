package com.smrtgrdyn.smrtgrdyn.Garden.Registration;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GardenRegistrationRequest {

    @Id
    String piId;
    String username;

    public GardenRegistrationRequest(String piId, String username) {
        this.piId = piId;
        this.username = username;
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
                '}';
    }
}
