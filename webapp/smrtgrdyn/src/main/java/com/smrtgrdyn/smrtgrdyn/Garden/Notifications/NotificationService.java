package com.smrtgrdyn.smrtgrdyn.Garden.Notifications;

import com.smrtgrdyn.smrtgrdyn.Garden.Repository.NotificationRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final ValidationUtil validationUtil;
    @Autowired
    public NotificationService(NotificationRepository notificationRepository, ValidationUtil validationUtil) {
        this.notificationRepository = notificationRepository;
        this.validationUtil = validationUtil;
    }

    public void addNotification(Notification notification){

        validationUtil.validateNotification(notification);

        notificationRepository.save(notification);

    }

    public List<Notification> getNotifications(UUID gardenId){

        notificationRepository.findAll();
        return notificationRepository.findAllByGardenId(gardenId);
    }
}
