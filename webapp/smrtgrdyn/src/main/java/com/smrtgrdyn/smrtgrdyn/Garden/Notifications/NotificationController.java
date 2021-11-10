package com.smrtgrdyn.smrtgrdyn.Garden.Notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notifications")
public class NotificationController {

    private final NotificationService service;

    @Autowired
    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public void addNotification(@RequestBody Notification notification){

        service.addNotification(notification);
    }

    @GetMapping
    public List<Notification> getNotifications(@RequestParam("gardenId") String gardenId){
        return List.copyOf(service.getNotifications(gardenId));
    }
}
