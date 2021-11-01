package com.smrtgrdyn.smrtgrdyn.Garden.Registration;

import com.smrtgrdyn.smrtgrdyn.Garden.Connection.GardenConnectionInformation;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenConnectionInformationRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenRegistrationRequestRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.UserInformationRepository;
import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.Registration;
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
    private UserInformationRepository userInformationRepository;


    private GardenConnectionInformation gardenConnectionInformation;
    private GardenRegistrationRequest gardenRegistrationRequest;


    @Autowired
    public GardenRegistrationService(GardenRegistrationRequestRepository pairingRepository,
                                     GardenConnectionInformationRepository gardenConnectionInformationRepository,
                                     UserInformationRepository userInformationRepository) {
        this.registrationRequestRepository = pairingRepository;
        this.gardenConnectionInformationRepository = gardenConnectionInformationRepository;
        this.userInformationRepository = userInformationRepository;
    }

    public UUID confirmRegistration(String username, GardenRegistrationRequest request) {

        Optional<GardenRegistrationRequest> optionalGardenRegistrationRequest =
                registrationRequestRepository.findById(request.getPiId());

        // Verify request is by same user
        if (optionalGardenRegistrationRequest.isPresent()) {
            if (optionalGardenRegistrationRequest.get().getUsername().equals(username)) {

                /*
                *  sendUUID to pi will currently NOT work as the server only tests locally
                * */
                //   sendUUIDToPi(optionalGardenRegistrationRequest.get().getGardenId());

                // Complete registration with that user
                registerGardenWithUser(optionalGardenRegistrationRequest.get().getUsername(),
                        optionalGardenRegistrationRequest.get().getGardenId());

                // Return the generated gardenId and drop the registration request
                UUID returnableGardenId = optionalGardenRegistrationRequest.get().getGardenId();
                registrationRequestRepository.deleteById(optionalGardenRegistrationRequest.get().getPiId());
                return returnableGardenId;

            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid User");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Registration Request Not Found");
        }

    }

    private void registerGardenWithUser(String username, UUID gardenId) {
        Optional<User> userOptional = userInformationRepository.findById(username);

        // Check registration, if already registered throw an error
        if(isGardenRegistered(gardenId)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Garden Already Registered");
        }

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.getRegisteredGardens().add(gardenId);

            // Spring Data JPA allows save() to function as update()
            userInformationRepository.save(user);

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not Registered");
        }
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
    private void sendUUIDToPi(UUID gardenId) {

        Optional<GardenConnectionInformation> optionalGardenConnectionInformation =
                gardenConnectionInformationRepository.findById(gardenId);

        if (optionalGardenConnectionInformation.isPresent()) {
            try {
                Socket socket = new Socket(optionalGardenConnectionInformation.get().getHostName(),
                        optionalGardenConnectionInformation.get().getPortNumber());
                if (socket.isConnected()) {
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

    public void openRegistrationRequest(HttpServletRequest servletRequest, GardenRegistrationRequest registrationRequest) {

        // Set connection information
        setConnectionInformation(servletRequest, registrationRequest);
        // Set request information
        setRequestInformation(registrationRequest);
        // Save Both Entities
        saveConnectionAndRequestInformation();
        // Start timer for registration window
        startRegistrationTimer();

    }

    private void setConnectionInformation(HttpServletRequest servletRequest, GardenRegistrationRequest registrationRequest){
        //Extracted Values for clarity
        String host = servletRequest.getHeader(HttpHeaders.HOST);
        Integer port = servletRequest.getServerPort();
        UUID gardenId = UUID.randomUUID();
        String username = registrationRequest.getUsername();

        this.gardenConnectionInformation = new GardenConnectionInformation(gardenId, username, host, port);

    }

    private void setRequestInformation(GardenRegistrationRequest registrationRequest){

        // Set registration Request's gardenId
        // Extracted for Clarity
        UUID gardenId = this.gardenConnectionInformation.getGardenId();
        registrationRequest.setGardenId(gardenId);
        // Store request
        this.gardenRegistrationRequest = registrationRequest;

        registrationRequestRepository.save(this.gardenRegistrationRequest);

    }

    private void saveConnectionAndRequestInformation(){

        registrationRequestRepository.save(this.gardenRegistrationRequest);
        gardenConnectionInformationRepository.save(this.gardenConnectionInformation);

    }

    private void startRegistrationTimer(){
        new GardenRegistrationServiceThread(
                this.gardenRegistrationRequest.getPiId(),
                this.gardenRegistrationRequest.getGardenId())
                .start();
    }


    private class GardenRegistrationServiceThread extends Thread {

        private String piId;
        UUID gardenId;

        public GardenRegistrationServiceThread(String piId, UUID gardenId) {
            this.piId = piId;
            this.gardenId = gardenId;
        }

        @Override
        public void run() {
            try {
                //Sleep time denotes how long the registration request can stay open
                Thread.sleep(300000);

                dropRequest();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void dropRequest(){
            Optional<GardenRegistrationRequest> registrationRequestOptional =
                    registrationRequestRepository.findById(this.piId);

            if (registrationRequestOptional.isPresent()) {
                gardenConnectionInformationRepository.deleteById(this.gardenId);
                registrationRequestRepository.deleteById(this.piId);
            }
        }
    }


}
