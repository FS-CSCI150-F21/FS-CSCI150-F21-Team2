package com.smrtgrdyn.smrtgrdyn.Garden.Repository;

import com.smrtgrdyn.smrtgrdyn.Garden.Notifications.Notification;
import com.smrtgrdyn.smrtgrdyn.Garden.Notifications.NotificationId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, NotificationId> {


//    @Query(value = "SELECT * FROM notification_table WHERE "
//                    + "garden_id = :gardenId", nativeQuery = true)
    // Quick and Dirty Fix to a Null result that shouldn't be null
    default List<Notification> findAllByGardenId(UUID gardenId){
        List<Notification> ret = new ArrayList<>();
        for(Notification n : findAll()){
            if(n.getGardenId().equals(gardenId)){
                ret.add(n);
            }
        }
        return ret;
    }


}
