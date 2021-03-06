package com.smrtgrdyn.smrtgrdyn.User.Registration;

import com.smrtgrdyn.smrtgrdyn.Garden.Repository.UserInformationRepository;
import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.Optional;

@Service
public class UserRegistrationService {

    private final UserInformationRepository userInformationRepository;

    @Autowired
    public UserRegistrationService(UserInformationRepository userInformationRepository) {
        this.userInformationRepository = userInformationRepository;
    }

    public void registerUser(@NotNull User user) throws IOException {

        //1. Check to see if username has been already been used
        Optional<User> userOptional = userInformationRepository.findById(user.getUsername());
        if(!userInformationRepository.existsById(user.getUsername())){

            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
            userInformationRepository.save(user);

        } else{

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username is already registered");
        }


    }
}
