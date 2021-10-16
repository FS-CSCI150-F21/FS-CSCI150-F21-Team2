package com.smrtgrdyn.smrtgrdyn.Garden;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class GardenSensorDataId implements Serializable {

    private UUID id;
    private String timestamp;

    public GardenSensorDataId(UUID id, String timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public GardenSensorDataId() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GardenSensorDataId that = (GardenSensorDataId) o;
        return id.equals(that.id) && timestamp.equals(that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp);
    }

    @Override
    public String toString() {
        return "GardenSensorDataId{" +
                "id=" + id +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
