package com.smrtgrdyn.smrtgrdyn.Garden;

import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.net.InetAddress;
import java.util.UUID;

@Entity
@Table(name = "garden_information")
//@IdClass(GardenInformationId.class)
public class GardenInformation {

    @Id
    UUID gardenId;

    @NotBlank
    String user;
    @NotBlank
    String hostName;
    @NotBlank
    Integer portNumber;

    // List<Sensor> sensorSuite; -- Potential future modification


    public GardenInformation(UUID gardenId, String user, String hostName, Integer portNumber) {
        this.gardenId = gardenId;
        this.user = user;
        this.hostName = hostName;
        this.portNumber = portNumber;
    }

    public GardenInformation() {
    }

    public UUID getGardenId() {
        return gardenId;
    }

    public void setGardenId(UUID gardenId) {
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
