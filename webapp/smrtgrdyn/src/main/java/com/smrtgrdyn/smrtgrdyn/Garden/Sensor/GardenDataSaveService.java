package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.smrtgrdyn.smrtgrdyn.Garden.Connection.GardenConnectionInformation;
import com.smrtgrdyn.smrtgrdyn.Garden.Connection.GardenConnectionInformationRepository;
import com.smrtgrdyn.smrtgrdyn.User.Registration.UserInformationRepository;
import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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
        gardenDataRepository.save(sensorData);
//        if(isGardenRegistered(sensorData.getGardenId())){
//            gardenDataRepository.save(sensorData);
//        }

    }

    private boolean isGardenRegistered(UUID gardenId){

        // Having Connection Info indicates that it has been registered
        // or is in the process of being registered
        Optional<GardenConnectionInformation> optionalGardenConnectionInformation =
                gardenConnectionInformationRepository.findById(gardenId);

        if(optionalGardenConnectionInformation.isPresent()){
            //Verify that the garden is attached to the User account
            // as this only happens once registration is complete
            String username = optionalGardenConnectionInformation.get().getUser();
            Optional<User> optionalUser = userInformationRepository.findById(username);

            if(optionalUser.isPresent()){
                return optionalUser.get().getRegisteredGardens().contains(gardenId);
            }
        }

        return false;
    }

    public GardenSensorData getLatestData(GardenDataRequest request){

        Optional<GardenSensorData> gardenSensorDataOptional = gardenDataRepository.findLatestByGardenId(request.getGardenId());

        if(gardenSensorDataOptional.isPresent()){
            return gardenSensorDataOptional.get();
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No data found");


    }

    public List getDataFromRange(GardenDataRequest request){

        System.out.println(request.getStart());
        System.out.println(request.getEnd());

        gardenDataRepository.findAll();
        List<GardenSensorData> dataList =
                gardenDataRepository
                        .findAllDataInRangeById(request.getGardenId(), request.getStart(), request.getEnd());


        if (!dataList.isEmpty()){
            for(GardenSensorData d : dataList){
                System.out.println(d.toString());
            }
            return List.copyOf(dataList);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No data found");
    }
}
