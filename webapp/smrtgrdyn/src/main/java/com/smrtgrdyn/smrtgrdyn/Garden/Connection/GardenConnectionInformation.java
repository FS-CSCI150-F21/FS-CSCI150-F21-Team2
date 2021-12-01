package com.smrtgrdyn.smrtgrdyn.Garden.Connection;

import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "garden_information")
public class GardenConnectionInformation {

    @Id
    String gardenId;


    String user;
    @NotBlank
    String hostName;
    @NotBlank
    Integer portNumber;

    // List<Sensor> sensorSuite; -- Potential future modification


    public GardenConnectionInformation(String gardenId, String user, String hostName, Integer portNumber) {
        this.gardenId = gardenId;
        this.user = user;
        this.hostName = hostName;
        this.portNumber = portNumber;
    }

    public GardenConnectionInformation() {
    }

    public String getGardenId() {
        return gardenId;
    }

    public void setGardenId(String gardenId) {
        this.gardenId = gardenId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(Integer portNumber) {
        this.portNumber = portNumber;
    }
}
