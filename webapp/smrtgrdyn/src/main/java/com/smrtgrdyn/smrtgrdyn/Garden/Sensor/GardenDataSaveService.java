package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;


import com.smrtgrdyn.smrtgrdyn.Garden.Connection.GardenConnectionInformation;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenConnectionInformationRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenDataRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.UserInformationRepository;
import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GardenDataSaveService {

    private final GardenDataRepository gardenDataRepository;
    private final GardenConnectionInformationRepository gardenConnectionInformationRepository;
    private final UserInformationRepository userInformationRepository;

    @Autowired
    public GardenDataSaveService(GardenDataRepository gardenDataRepository,
                                 GardenConnectionInformationRepository gardenConnectionInformationRepository,
                                 UserInformationRepository userInformationRepository){
        this.gardenDataRepository = gardenDataRepository;
        this.gardenConnectionInformationRepository = gardenConnectionInformationRepository;
        this.userInformationRepository = userInformationRepository;
    }

    public void saveGardenData(HttpServletRequest request, GardenSensorData sensorData){

        if(isGardenRegistered(sensorData.getGardenId())){

            gardenDataRepository.save(sensorData);
        }

    }

    private void updateConnectionInformation(HttpServletRequest request, String gardenId){

        //Extracted Values for clarity
        String host = request.getRemoteHost();
        Integer port = request.getRemotePort();

        Optional<GardenConnectionInformation> info = gardenConnectionInformationRepository.findById(gardenId);

        if(info.isPresent()){
            info.get().setHostName(host);
            info.get().setPortNumber(port);
            gardenConnectionInformationRepository.save(info.get());
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Garden Not Registered");
        }



    }

    private boolean isGardenRegistered(String gardenId){

        String username = getUsernameFromGardenId(gardenId);

        return isGardenRegisteredToUser(username, gardenId);

    }

    private String getUsernameFromGardenId(String gardenId){

        gardenConnectionInformationRepository.findAll();
        Optional<GardenConnectionInformation> optionalConnection =
                gardenConnectionInformationRepository.findById(gardenId);

        if(optionalConnection.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Garden Not Registered");
        }

        return optionalConnection.get().getUser();

    }

    private boolean isGardenRegisteredToUser(String username, String gardenId){

        Optional<User> optionalUser = userInformationRepository.findById(username);

        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!");
        }
        return optionalUser.get().getRegisteredGardens().contains(gardenId);
    }


    public GardenSensorData getLatestData(GardenDataRequest request){
        if(isGardenRegistered(request.getGardenId())){
            List<GardenSensorData> gardenSensorDataOptional =
                    gardenDataRepository.findLatestEntryByGardenId(request.getGardenId());

            if(gardenSensorDataOptional.isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No data found");
            }

            return gardenSensorDataOptional.get(0);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Garden Not Registered");

    }

    public List<GardenSensorData> getDataFromRange(GardenDataRequest request){

        List<GardenSensorData> dataList = getListOfGardenData(request.getGardenId(), request.getStart(), request.getEnd());

        if (!dataList.isEmpty()){
            return List.copyOf(dataList);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No data found");
    }

    private List<GardenSensorData> getListOfGardenData(String gardenId, Timestamp start, Timestamp end){
        gardenDataRepository.findAll();
        return  (List<GardenSensorData>) gardenDataRepository.findByGardenIdAndTimestampBetween(gardenId, start, end);
    }
}
