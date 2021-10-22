package com.smrtgrdyn.smrtgrdyn.Garden.Registration;

import com.smrtgrdyn.smrtgrdyn.Garden.GardenConnectionInformation;
import com.smrtgrdyn.smrtgrdyn.Garden.GardenConnectionInformationRepository;
import com.smrtgrdyn.smrtgrdyn.User.Registration.UserInformationRepository;
import com.smrtgrdyn.smrtgrdyn.User.User;
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
public class GardenRegistrationService {

    private final GardenRegistrationRequestRepository registrationRequestRepository;
    private final GardenConnectionInformationRepository gardenConnectionInformationRepository;

    private GardenConnectionInformation gardenConnectionInformation;
    private GardenRegistrationRequest gardenRegistrationRequest;
    private UserInformationRepository userInformationRepository;

    @Autowired
    public GardenRegistrationService(GardenRegistrationRequestRepository pairingRepository,
                                     GardenConnectionInformationRepository gardenConnectionInformationRepository,
                                     UserInformationRepository userInformationRepository){
        this.registrationRequestRepository = pairingRepository;
        this.gardenConnectionInformationRepository = gardenConnectionInformationRepository;
        this.userInformationRepository = userInformationRepository;
    }

    public void confirmRegistration(String username, GardenRegistrationRequest request){

        //Check registrationRequest table for request
        //if present pull send UUID to garden and drop request

        //to send UUID to garden pull connection info and open socket to pi
        //send UUID to pi through socket
        //This pulls a registration request from the database based on the piId
        Optional<GardenRegistrationRequest> optionalGardenRegistrationRequest =
                registrationRequestRepository.findById(request.getPiId());

        //Checks the request against the username
        if(optionalGardenRegistrationRequest.isPresent()){
            if(optionalGardenRegistrationRequest.get().getUsername().equals(username)){

             //   sendUUIDToPi(optionalGardenRegistrationRequest.get().getGardenId());

                registerGardenWithUser(optionalGardenRegistrationRequest.get().getUsername(),
                          optionalGardenRegistrationRequest.get().getGardenId());

                //then drop the registration request from the db
                registrationRequestRepository.deleteById(optionalGardenRegistrationRequest.get().getPiId());
                System.out.println("Registration confirmed");

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
        this.gardenRegistrationRequest.setGardenId(gardenId);
        //Registration Request should contain all information
        registrationRequestRepository.save(this.gardenRegistrationRequest);
        gardenConnectionInformationRepository.save(gardenConnectionInformation);

        //Start timing thread to drop entry once time limit is up
        // Look up a thread or runnable statement
        GardenRegistrationServiceThread thread =
                new GardenRegistrationServiceThread(
                        gardenRegistrationRequest.getPiId(), gardenId);
        thread.start();

    }

    private void registerGardenWithUser(String username, UUID gardenId){
        Optional<User> userOptional = userInformationRepository.findById(username);

        if(userOptional.isPresent()){
            User user = userOptional.get();
            //   user.addGarden(gardenId);
            user.getRegisteredGardens().add(gardenId);
            userInformationRepository.save(user);

        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not Registered");
        }
    }

    private class GardenRegistrationServiceThread extends Thread{

        private String piId;
        UUID gardenId;

        public GardenRegistrationServiceThread(String piId, UUID gardenId) {
            this.piId = piId;
            this.gardenId = gardenId;
        }

        @Override
        public void run() {
            try{

                Thread.sleep(300000);

                Optional<GardenRegistrationRequest> registrationRequestOptional =
                        registrationRequestRepository.findById(this.piId);

                //If it is present, that means registration failed, drop entries from both tables
                if (registrationRequestOptional.isPresent()){
                    gardenConnectionInformationRepository.deleteById(this.gardenId);
                    registrationRequestRepository.deleteById(this.piId);
                }

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
