package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smrtgrdyn.smrtgrdyn.Garden.Connection.GardenConnectionInformation;
import com.smrtgrdyn.smrtgrdyn.Garden.Connection.GardenConnectionInformationRepository;
import com.smrtgrdyn.smrtgrdyn.User.Registration.UserInformationRepository;
import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GardenDataSaveService {

    private final GardenDataRepository gardenDataRepository;
    private final GardenConnectionInformationRepository gardenConnectionInformationRepository;
    private final UserInformationRepository userInformationRepository;

    @Autowired //This allows a dependency injection so we don't have to instantiate the repo
    public GardenDataSaveService(GardenDataRepository gardenDataRepository,
                                 GardenConnectionInformationRepository gardenConnectionInformationRepository,
                                 UserInformationRepository userInformationRepository){
        this.gardenDataRepository = gardenDataRepository;
        this.gardenConnectionInformationRepository = gardenConnectionInformationRepository;
        this.userInformationRepository = userInformationRepository;
    }

    public void saveGardenData(GardenSensorData sensorData){
        /*
        * 1. Get Garden Sensor Data
        * 2. Verify Garden is Registered via GardenInformationRepo
        * 3. Store Garden Data*/

        if(isGardenRegistered(sensorData.getGardenId())){
            gardenDataRepository.save(sensorData);
        }

    }

    private boolean isGardenRegistered(UUID gardenId){

        Optional<GardenConnectionInformation> optionalGardenConnectionInformation =
                gardenConnectionInformationRepository.findById(gardenId);

        if(optionalGardenConnectionInformation.isPresent()){
            String username = optionalGardenConnectionInformation.get().getUser();
            Optional<User> optionalUser = userInformationRepository.findById(username);

            if(optionalUser.isPresent()){
                return optionalUser.get().getRegisteredGardens().contains(gardenId);
            }
        }

        return false;
    }
}
