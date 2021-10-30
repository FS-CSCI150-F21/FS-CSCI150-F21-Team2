package com.smrtgrdyn.smrtgrdyn.User.Registration;

import com.smrtgrdyn.smrtgrdyn.Garden.Repository.UserInformationRepository;
import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserRegistrationService {

    private final UserInformationRepository userInformationRepository;

    @Autowired
    public UserRegistrationService(UserInformationRepository userInformationRepository) {
        this.userInformationRepository = userInformationRepository;
    }

    public void registerUser(@org.jetbrains.annotations.NotNull User user){

        //1. Check to see if username has been already been used
        Optional<User> userOptional = userInformationRepository.findById(user.getUsername());

        if(userOptional.isEmpty()){
            user.setStoredSalt(BCrypt.gensalt(10));
            user.setPassword(BCrypt.hashpw(user.getPassword(), user.getStoredSalt()));
            userInformationRepository.save(user);
        } else{

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username is already registered");
        }


    }
}
