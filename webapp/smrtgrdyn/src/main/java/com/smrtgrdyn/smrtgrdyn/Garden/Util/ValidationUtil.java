package com.smrtgrdyn.smrtgrdyn.Garden.Util;

import com.smrtgrdyn.smrtgrdyn.Garden.Connection.GardenConnectionInformation;
import com.smrtgrdyn.smrtgrdyn.Garden.Image.GardenImage;
import com.smrtgrdyn.smrtgrdyn.Garden.Image.GardenImageId;
import com.smrtgrdyn.smrtgrdyn.Garden.Notifications.Notification;
import com.smrtgrdyn.smrtgrdyn.Garden.Notifications.NotificationId;
import com.smrtgrdyn.smrtgrdyn.Garden.Notifications.NotificationType;
import com.smrtgrdyn.smrtgrdyn.Garden.Registration.GardenRegistrationRequest;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.*;
import com.smrtgrdyn.smrtgrdyn.User.Control.ControlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.apache.commons.lang3.EnumUtils;

import java.util.Arrays;
import java.util.Optional;


/**
*
 * Validation Utility Class
 *
 * This Validation Utility is used to ensure that all data being stored is "Valid",
 * eg, It has all fields properly filled out, and will not
 * interfere with other saved entities.
 *
* */
@Service
public class ValidationUtil {


    private final GardenImageRepository images;
    private final GardenConnectionInformationRepository gardens;
    private final GardenRegistrationRequestRepository registrations;
    private final NotificationRepository notifications;
    private final UserInformationRepository users;

    @Autowired
    public ValidationUtil(GardenImageRepository images,
                          GardenConnectionInformationRepository gardens,
                          GardenRegistrationRequestRepository registrations,
                          NotificationRepository notifications, UserInformationRepository users) {
        this.images = images;
        this.gardens = gardens;
        this.registrations = registrations;
        this.notifications = notifications;
        this.users = users;
    }


    /**
     * Image Validation ensures the following:
     *      - Submitted with a valid timestamp
     *      - Submitted with a Valid UUID
     *      - Submitted with a Valid Filepath.
     *
     *  Valid in this case means, the values are unique with respect to the UUID submitted,
     *  and the UUID that is submitted is also registered
     */
    public void validateImage(GardenImage gardenImage){


       // Check the UUID to verify registration
       if(!isUUIDValid(gardenImage.getGardenId())){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid UUID");
       }

        //If no timestamp given, generate one
        if(!isImageTimestampValid(gardenImage)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Timestamp");
        }

       if(!isFilepathValid(gardenImage.getFilepath())){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Duplicate Images");
       }

    }

    /**
     * A valid UUID is a UUID that is saved in the ConnectionInformation Table
     * And is not found in open registration requests
     * */
    private boolean isUUIDValid(String gardenId){


        Optional<GardenConnectionInformation> gardenConnection =
                gardens.findById(gardenId);

        Optional<GardenRegistrationRequest> registrationRequest =
                registrations.findByGardenId(gardenId);

        return gardenConnection.isPresent() && registrationRequest.isEmpty();
    }

    private boolean isImageTimestampValid(GardenImage gardenImage){
        if(gardenImage.getTimestamp() == null){
            return false;
        }

        Optional<GardenImage> optionalGardenImage =
                images.findById(new GardenImageId(gardenImage.getGardenId(), gardenImage.getTimestamp()));

        return optionalGardenImage.isEmpty();
    }



    private boolean isFilepathValid(String filepath){
        return !SGFileUtils.doesFileExist(filepath);
    }

    public void validateNotification(Notification notification){

        if(!isUUIDValid(notification.getGardenId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid UUID");
        }

        if(!isNotificationTimestampValid(notification)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Timestamp");
        }

        if(!isNotificationTypeValid(notification)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Notification Type");
        }
        if(notification.getMessage() == null){
            notification.setMessageByType();
        }
    }

    private boolean isNotificationTimestampValid(Notification notification){

        if(notification.getTimestamp() == null){
            return false;
        }

        Optional<Notification> optionalNotification =
                notifications.findById(new NotificationId(notification.getGardenId(), notification.getTimestamp(), notification.getType()));

        return optionalNotification.isEmpty();


    }

    private boolean isNotificationTypeValid(Notification notification){

        for(NotificationType enumVal : NotificationType.values()){
            System.out.println(enumVal.getType());
            if(enumVal.getType().equals(notification.getType())){
                return true;
            }
        }
        return false;

    }

    public boolean validateControlRequest(ControlRequest request, String username){
        //Validation: gardenId is Registered AND is Saved under User
        if(!isUUIDValid(request.getGardenId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid UUID");
        }

        if(!isUUIDRegisteredToUser(request.getGardenId(), username)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Registration");
        }

        return true;
    }

    private boolean isUUIDRegisteredToUser(String gardenId, String username){

        return gardens.findById(gardenId).get().getUser().equals(username) &&
                users.findById(username).get().getRegisteredGardens().contains(gardenId);
    }
}
