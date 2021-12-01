package com.smrtgrdyn.smrtgrdyn.Garden.Connection;

import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenConnectionInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class GardenConnectionService {

    private final GardenConnectionInformationRepository connections;


    @Autowired
    public GardenConnectionService(GardenConnectionInformationRepository connections) {
        this.connections = connections;
    }


    public void updateConnectionInformation(GardenConnectionInformation information){

        Optional<GardenConnectionInformation> info = connections.findById(information.getGardenId());

        if(info.isPresent()){

            info.get().setHostName(information.getHostName());
            info.get().setPortNumber(information.getPortNumber());
            connections.save(info.get());
        }
        else{

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Garden Not Registered");
        }
    }

    public GardenConnectionInformation getConnectionInformation(String gardenId, String username){

        Optional<GardenConnectionInformation> info = connections.findById(gardenId);

        if(info.isPresent()){
            if(info.get().getUser() == username){
                return info.get();
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid User");
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Garden Not Registered");

    }
}
