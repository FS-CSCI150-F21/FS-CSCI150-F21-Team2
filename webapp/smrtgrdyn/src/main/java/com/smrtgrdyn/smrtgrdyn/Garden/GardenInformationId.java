package com.smrtgrdyn.smrtgrdyn.Garden;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;


public class GardenInformationId implements Serializable {

    private UUID id;
    private String user;

    public GardenInformationId(UUID id, String user) {
        this.id = id;
        this.user = user;
    }

    public GardenInformationId() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GardenInformationId that = (GardenInformationId) o;
        return id.equals(that.id) && user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user);
    }

    @Override
    public String toString() {
        return "GardenInformationId{" +
                "id=" + id +
                ", user='" + user + '\'' +
                '}';
    }
}
