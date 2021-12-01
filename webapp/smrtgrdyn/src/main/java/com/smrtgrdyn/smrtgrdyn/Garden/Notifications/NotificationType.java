package com.smrtgrdyn.smrtgrdyn.Garden.Notifications;

public enum NotificationType {
    LEAK("leak"), ANIMAL("animal");

    private String type;
    NotificationType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


}
