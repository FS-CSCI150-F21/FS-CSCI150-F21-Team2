package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;

import java.sql.Timestamp;
import java.util.UUID;

public class GardenDataRequest {

    private UUID gardenId;
    private Timestamp start;
    private Timestamp end;

    public GardenDataRequest(UUID gardenId) {
        this.gardenId = gardenId;
    }

    public GardenDataRequest(UUID gardenId, Timestamp start, Timestamp end) {
        this.gardenId = gardenId;
        this.start = start;
        this.end = end;
    }

    public UUID getGardenId() {
        return gardenId;
    }

    public void setGardenId(UUID gardenId) {
        this.gardenId = gardenId;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }
}
