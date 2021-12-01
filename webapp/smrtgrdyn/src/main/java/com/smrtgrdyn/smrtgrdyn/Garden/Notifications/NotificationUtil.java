package com.smrtgrdyn.smrtgrdyn.Garden.Notifications;

import com.smrtgrdyn.smrtgrdyn.Garden.Repository.NotificationRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class NotificationUtil {

    private final NotificationRepository notifications;
    private final ValidationUtil validationUtil;

    @Autowired
    public NotificationUtil(NotificationRepository notifications, ValidationUtil validationUtil) {
        this.notifications = notifications;
        this.validationUtil = validationUtil;
    }

    public void generateNotification(String gardenId, Timestamp timestamp, NotificationType type, String message){
        if (message == null) message = "";
        Notification notification = new Notification(gardenId, timestamp, type.getType(), message);
        validationUtil.validateNotification(notification);
        notifications.save(notification);
    }
}
