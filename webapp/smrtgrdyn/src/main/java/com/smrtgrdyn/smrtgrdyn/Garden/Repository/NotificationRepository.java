package com.smrtgrdyn.smrtgrdyn.Garden.Repository;

import com.smrtgrdyn.smrtgrdyn.Garden.Notifications.Notification;
import com.smrtgrdyn.smrtgrdyn.Garden.Notifications.NotificationId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, NotificationId> {


    @Query(value = "SELECT * FROM notification_table WHERE "
                    + "garden_id = :gardenId", nativeQuery = true)
    List<Notification> findAllByGardenId(@Param("gardenId") UUID gardenId);
}
