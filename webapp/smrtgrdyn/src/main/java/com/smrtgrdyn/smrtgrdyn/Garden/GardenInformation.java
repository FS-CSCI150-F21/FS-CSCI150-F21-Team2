package com.smrtgrdyn.smrtgrdyn.Garden;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.InetAddress;
import java.util.UUID;

@Entity
public class GardenInformation {

    @Id
    UUID gardenId;

    String user;
    InetAddress ipAddress;
    // List<Sensor> sensorSuite; -- Potential future modification


    public GardenInformation(UUID gardenId, String user, InetAddress ipAddress) {
        this.gardenId = gardenId;
        this.user = user;
        this.ipAddress = ipAddress;
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

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "GardenInformation{" +
                "gardenId=" + gardenId +
                ", user='" + user + '\'' +
                ", ipAddress=" + ipAddress +
                '}';
    }
}
