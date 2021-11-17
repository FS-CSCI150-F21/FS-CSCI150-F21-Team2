package com.smrtgrdyn.smrtgrdyn.User.Control;

import com.smrtgrdyn.smrtgrdyn.Garden.Connection.GardenConnectionInformation;
import com.smrtgrdyn.smrtgrdyn.Garden.Repository.GardenConnectionInformationRepository;
import com.smrtgrdyn.smrtgrdyn.Garden.Util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Optional;

@Service
public class UserControlService {

    private final ValidationUtil validationUtil;
    private final GardenConnectionInformationRepository connection;

    public UserControlService(ValidationUtil validationUtil, GardenConnectionInformationRepository connection) {
        this.validationUtil = validationUtil;
        this.connection = connection;
    }

    public void sendControlSignal(ControlRequest request, String username){

        if(validationUtil.validateControlRequest(request, username)){
            connectAndSendSignal(request);
        }

    }

    private void connectAndSendSignal(ControlRequest request){

        Optional<GardenConnectionInformation> connectionInformation = 
                connection.findById(request.getGardenId());

        if(connectionInformation.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to Connect to Garden");
        }

        try {
            Socket socket = new Socket(connectionInformation.get().getHostName(),
                    connectionInformation.get().getPortNumber());
            if (socket.isConnected()) {
                //Setup Output Stream
                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

                //Write to outputStream
                dataOutputStream.writeChars(request.getControlSignal());

                //Flush and Close Stream and Socket
                dataOutputStream.flush();
                dataOutputStream.close();
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not Connect to Garden", e);
        }


    }


}
