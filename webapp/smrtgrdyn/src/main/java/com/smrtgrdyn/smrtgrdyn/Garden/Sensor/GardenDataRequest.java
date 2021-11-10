package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;

import java.sql.Timestamp;

public class GardenDataRequest {

    private String gardenId;
    private Timestamp start;
    private Timestamp end;

    public GardenDataRequest(String gardenId) {
        this.gardenId = gardenId;
    }

    public GardenDataRequest(String gardenId, Timestamp start, Timestamp end) {
        this.gardenId = gardenId;
        this.start = start;
        this.end = end;
    }

    public String getGardenId() {
        return gardenId;
    }

    public void setGardenId(String gardenId) {
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
