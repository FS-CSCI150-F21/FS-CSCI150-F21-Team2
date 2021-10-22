package com.smrtgrdyn.smrtgrdyn.Garden.Registration;

import com.smrtgrdyn.smrtgrdyn.Garden.GardenConnectionInformation;
import com.smrtgrdyn.smrtgrdyn.Garden.GardenConnectionInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Optional;
import java.util.UUID;

@Service
public class GardenRegistrationService implements Runnable{

    private final GardenRegistrationRequestRepository registrationRequestRepository;
    private final GardenConnectionInformationRepository gardenConnectionInformationRepository;

    private GardenConnectionInformation gardenConnectionInformation;
    private GardenRegistrationRequest gardenRegistrationRequest;


    @Autowired
    public GardenRegistrationService(GardenRegistrationRequestRepository pairingRepository,
                                     GardenConnectionInformationRepository gardenConnectionInformationRepository){
        this.registrationRequestRepository = pairingRepository;
        this.gardenConnectionInformationRepository = gardenConnectionInformationRepository;
    }

    public void confirmRegistration(String username, String piId){


        //Check registrationRequest table for request
        //if present pull send UUID to garden and drop request

        //to send UUID to garden pull connection info and open socket to pi
        //send UUID to pi through socket
        //This pulls a registration request from the database based on the piId
        Optional<GardenRegistrationRequest> optionalGardenRegistrationRequest =
                registrationRequestRepository.findById(piId);

        //Checks the request against the username
        if(optionalGardenRegistrationRequest.isPresent()){
            if(optionalGardenRegistrationRequest.get().getUsername().equals(username)){

                sendUUIDToPi(optionalGardenRegistrationRequest.get().getGardenId());
                //then drop the registration request from the db

                registrationRequestRepository.delete(optionalGardenRegistrationRequest.get());

            }else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid User");
            }


        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Registration Request Not Found");

        }
    }

    private void sendUUIDToPi(UUID gardenId){

        Optional<GardenConnectionInformation> optionalGardenConnectionInformation =
                gardenConnectionInformationRepository.findById(gardenId);

        if(optionalGardenConnectionInformation.isPresent()){
            try {
                Socket socket = new Socket(optionalGardenConnectionInformation.get().getHostName(),
                        optionalGardenConnectionInformation.get().getPortNumber());
                if(socket.isConnected()){
                    //Setup Output Stream
                    OutputStream outputStream = socket.getOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

                    //Write to outputStream
                    dataOutputStream.writeChars(gardenId.toString());

                    //Flush and Close Stream and Socket
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    socket.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not Connect to Pi", e);
            }
        }

    }
    public void requestRegistration(HttpServletRequest servletRequest, GardenRegistrationRequest registrationRequest)  {

        //1. Get Ip/Host Name of the request
        //2. Get the Port Number
        String host = servletRequest.getHeader(HttpHeaders.HOST);
        Integer port = servletRequest.getServerPort();

        //Generate UUID for Garden
        UUID gardenId = UUID.randomUUID();
        // Get Username for Garden information entry
        String username = registrationRequest.getUsername();

        this.gardenConnectionInformation = new GardenConnectionInformation(gardenId, username, host, port);
        this.gardenRegistrationRequest = registrationRequest;
        //Registration Request should contain all information
        registrationRequestRepository.save(this.gardenRegistrationRequest);
        gardenConnectionInformationRepository.save(gardenConnectionInformation);

        //Start timing thread to drop entry once time limit is up
        // Look up a thread or runnable statement
        this.run();

    }

    @Override
    public void run() {
        try{
            Thread.sleep(300000);

            Optional<GardenRegistrationRequest> registrationRequestOptional =
                    registrationRequestRepository.findById(this.gardenRegistrationRequest.getPiId());

            //If it is present, that means registration failed, drop entries from both tables
            if (registrationRequestOptional.isPresent()){
                gardenConnectionInformationRepository.deleteById(this.gardenConnectionInformation.getGardenId());
                registrationRequestRepository.deleteById(this.gardenRegistrationRequest.getPiId());
            }

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
