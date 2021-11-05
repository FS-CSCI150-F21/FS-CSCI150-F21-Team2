package com.smrtgrdyn.smrtgrdyn.Garden.Notifications;

import com.smrtgrdyn.smrtgrdyn.Garden.Repository.NotificationRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

public class NotificationUtil {

    private final NotificationRepository notifications;
    private final ValidationUtil validationUtil;
    
    @Autowired
    public NotificationUtil(NotificationRepository notifications, ValidationUtil validationUtil) {
        this.notifications = notifications;
        this.validationUtil = validationUtil;
    }

    public void generateNotification(String gardenId, Timestamp timestamp, NotificationType type){

        Notification notification = new Notification(gardenId, timestamp, type.getType());
        validationUtil.validateNotification(notification);
        notifications.save(notification);
    }
}
