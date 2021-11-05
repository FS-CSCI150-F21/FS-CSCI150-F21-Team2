package com.smrtgrdyn.smrtgrdyn.User.Control;

public class ControlRequest {

    private String gardenId;
    private String controlSignal;

    public ControlRequest(String gardenId, String controlSignal) {
        this.gardenId = gardenId;
        this.controlSignal = controlSignal;
    }

    public ControlRequest() {
    }

    public String getGardenId() {
        return gardenId;
    }

    public void setGardenId(String gardenId) {
        this.gardenId = gardenId;
    }

    public String getControlSignal() {
        return controlSignal;
    }

    public void setControlSignal(String controlSignal) {
        this.controlSignal = controlSignal;
    }

    @Override
    public String toString() {
        return "ControlRequest{" +
                "gardenId='" + gardenId + '\'' +
                ", controlSignal='" + controlSignal + '\'' +
                '}';
    }
}
