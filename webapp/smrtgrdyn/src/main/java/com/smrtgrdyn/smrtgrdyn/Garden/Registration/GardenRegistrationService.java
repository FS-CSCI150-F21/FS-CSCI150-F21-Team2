package com.smrtgrdyn.smrtgrdyn.Garden.Registration;

import com.smrtgrdyn.smrtgrdyn.Garden.Connection.GardenConnectionInformation;
import com.smrtgrdyn.smrtgrdyn.Garden.GardenName.GardenName;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenConnectionInformationRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenNameRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenRegistrationRequestRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.UserInformationRepository;
import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

@Service
public class GardenRegistrationService {

    private final GardenRegistrationRequestRepository registrationRequestRepository;
    private final GardenConnectionInformationRepository gardenConnectionInformationRepository;

    private final UserInformationRepository userInformationRepository;
    private final GardenNameRepository gardenNameRepository;

    private GardenConnectionInformation gardenConnectionInformation;
    private GardenRegistrationRequest gardenRegistrationRequest;


    @Autowired
    public GardenRegistrationService(GardenRegistrationRequestRepository pairingRepository,
                                     GardenConnectionInformationRepository gardenConnectionInformationRepository,
                                     UserInformationRepository userInformationRepository, GardenNameRepository gardenNameRepository) {

        this.registrationRequestRepository = pairingRepository;
        this.gardenConnectionInformationRepository = gardenConnectionInformationRepository;
        this.userInformationRepository = userInformationRepository;
        this.gardenNameRepository = gardenNameRepository;
    }

    public String confirmRegistration(String username, GardenRegistrationRequest request) {

        // Verify Username is the same one on the corresponding request
        setupRegistrationConfirmation(request.getPiId());

        if(username.equals(
                getRequestUsername(request.getPiId()))){

            // add garden to users information
            addGardenIdToUsersRegisteredGardens(
                    username,
                    gardenRegistrationRequest.getGardenId());

            // send UUID to Pi
            /*
             *  sendUUID to pi will currently NOT work as the server only tests locally
             * */
             //sendUUIDToPi(gardenRegistrationRequest.getGardenId());

            // Drop request
            dropRequest();
            return gardenRegistrationRequest.getGardenId();
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid User");
    }

    private void setupRegistrationConfirmation(String piId){

        if(registrationRequestRepository.findById(piId).isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Registration Request Not Found");
        }

        gardenRegistrationRequest = registrationRequestRepository.findById(piId).get();
    }

    private String getRequestUsername(String piId){
        return gardenRegistrationRequest.getUsername();
    }

    private void addGardenIdToUsersRegisteredGardens(String username, String gardenId){

        if(!isGardenAlreadyRegisteredWithUser(username, gardenId)){
            Optional<User> userOptional = userInformationRepository.findById(username);

            if(userOptional.isEmpty()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
            }
            User user = userOptional.get();

            user.getRegisteredGardens().add(gardenId);
            if(user.getDefaultGarden() == null){
                user.setDefaultGarden(gardenId);
            }

            userInformationRepository.save(user);
        }

    }

    private boolean isGardenAlreadyRegisteredWithUser(String username, String gardenId){
        Optional<User> userOptional = userInformationRepository.findById(username);

        if(userOptional.isPresent()){
            return userOptional.get().getRegisteredGardens().contains(gardenId);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
    }

    private void dropRequest(){
        registrationRequestRepository.delete(gardenRegistrationRequest);
    }

    public void setGardenName(GardenName gardenName){

        if(isGardenAlreadyRegisteredWithUser(gardenName.getUsername(), gardenName.getGardenId())){
            gardenNameRepository.save(gardenName);
            return;
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot Name Garden");
    }


//    private void sendUUIDToPi(String gardenId) {
//
//        Optional<GardenConnectionInformation> optionalGardenConnectionInformation =
//                gardenConnectionInformationRepository.findById(gardenId);
//
//        if (optionalGardenConnectionInformation.isPresent()) {
//            try {
//                Socket socket = new Socket(optionalGardenConnectionInformation.get().getHostName(),
//                        optionalGardenConnectionInformation.get().getPortNumber());
//                if (socket.isConnected()) {
//                    //Setup Output Stream
//                    OutputStream outputStream = socket.getOutputStream();
//                    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
//
//                    //Write to outputStream
//                    dataOutputStream.writeChars(gardenId.toString());
//
//                    //Flush and Close Stream and Socket
//                    dataOutputStream.flush();
//                    dataOutputStream.close();
//                    socket.close();
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not Connect to Garden", e);
//            }
//        }
//    }

    public void openRegistrationRequest(HttpServletRequest servletRequest, GardenRegistrationRequest registrationRequest) {

        // Set connection information
        setConnectionInformation(servletRequest, registrationRequest);
        // Set request information
        setRequestInformationWithConnectionInformation(registrationRequest);
        // Save Both Entities
        saveConnectionAndRequestInformation();
        // Start timer for registration window
        startRegistrationTimer();

    }

    private void setConnectionInformation(HttpServletRequest servletRequest, GardenRegistrationRequest registrationRequest){

        //Extracted Values for clarity
        String host = servletRequest.getRemoteHost();
        Integer port = servletRequest.getRemotePort();
        UUID id = UUID.randomUUID();
        String gardenId = id.toString();
        String username = registrationRequest.getUsername();

        if(!isUsernameRegistered(username)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Username");
        }

        this.gardenConnectionInformation = new GardenConnectionInformation(gardenId, username, host, port);

    }

    private boolean isUsernameRegistered(String username){
        return userInformationRepository.existsById(username);
    }
    private void setRequestInformationWithConnectionInformation(GardenRegistrationRequest registrationRequest){

        // Extracted for Clarity
        String gardenId = this.gardenConnectionInformation.getGardenId();

        // Set registration Request's gardenId
        registrationRequest.setGardenId(gardenId);

        // Set request
        this.gardenRegistrationRequest = registrationRequest;

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

        private final String piId;
        private final String gardenId;

        public GardenRegistrationServiceThread(String piId, String gardenId) {
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
