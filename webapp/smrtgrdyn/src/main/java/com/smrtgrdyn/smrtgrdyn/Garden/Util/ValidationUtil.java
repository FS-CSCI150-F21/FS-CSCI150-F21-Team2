package com.smrtgrdyn.smrtgrdyn.Garden.Util;

import com.smrtgrdyn.smrtgrdyn.Garden.Connection.GardenConnectionInformation;
import com.smrtgrdyn.smrtgrdyn.Garden.Image.GardenImage;
import com.smrtgrdyn.smrtgrdyn.Garden.Image.GardenImageId;
import com.smrtgrdyn.smrtgrdyn.Garden.Registration.GardenRegistrationRequest;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenConnectionInformationRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenImageRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenRegistrationRequestRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

public class ValidationUtil {


    private static GardenImageRepository images;
    private static GardenConnectionInformationRepository gardens;
    private static GardenRegistrationRequestRepository registrations;
    @Autowired
    public ValidationUtil(GardenImageRepository images,
                          GardenConnectionInformationRepository gardens,
                          GardenRegistrationRequestRepository registrations) {
        this.images = images;
        this.gardens = gardens;
        this.registrations = registrations;
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
    public static void validateImage(GardenImage gardenImage){

       //If no timestamp given, generate one
       if(!isTimestampValid(gardenImage)){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Timestamp");
       }

       // Check the UUID to verify registration
       if(!isUUIDValid(gardenImage.getGardenId())){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Timestamp");
       }

       if(!isFilepathValid(gardenImage.getFilepath())){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Duplicate Images");
       }

    }

    private static boolean isTimestampValid(GardenImage gardenImage){
        if(gardenImage.getTimestamp() == null){
            return false;
        }

        Optional<GardenImage> optionalGardenImage =
                images.findById(new GardenImageId(gardenImage.getGardenId(), gardenImage.getTimestamp()));

        return optionalGardenImage.isEmpty();
    }

    /**
     * A valid UUID is a UUID that is saved in the ConnectionInformation Table
     * And is not found in open registration requests
    * */
    private static boolean isUUIDValid(UUID gardenId){

        Optional<GardenConnectionInformation> gardenConnection =
                gardens.findById(gardenId);

        Optional<GardenRegistrationRequest> registrationRequest =
                registrations.findByGardenId(gardenId);

        return gardenConnection.isPresent() && registrationRequest.isEmpty();
    }

    private static boolean isFilepathValid(String filepath){
        return !SGFileUtils.doesFileExist(filepath);
    }
}
