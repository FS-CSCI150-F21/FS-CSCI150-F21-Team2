package com.smrtgrdyn.smrtgrdyn.Garden.Notifications;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class NotificationId implements Serializable {

    private String gardenId;
    private Timestamp timestamp;
    private String type;


    public NotificationId(String gardenId, Timestamp timestamp, String type) {
        this.gardenId = gardenId;
        this.timestamp = timestamp;
        this.type = type;
    }


    public NotificationId() {
    }


    public String getGardenId() {
        return gardenId;
    }

    public void setGardenId(String gardenId) {
        this.gardenId = gardenId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationId that = (NotificationId) o;
        return gardenId.equals(that.gardenId) && timestamp.equals(that.timestamp) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gardenId, timestamp, type);
    }
}
