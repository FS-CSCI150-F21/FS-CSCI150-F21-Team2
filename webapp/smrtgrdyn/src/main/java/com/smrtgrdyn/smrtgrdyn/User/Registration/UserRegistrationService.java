package com.smrtgrdyn.smrtgrdyn.User.Registration;

import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRegistrationService {

    private final UserInformationRepository userInformationRepository;

    @Autowired
    public UserRegistrationService(UserInformationRepository userInformationRepository) {
        this.userInformationRepository = userInformationRepository;
    }

    public void registerUser(User user){

        //1. Check to see if username has been already been used
        Optional<User> userOptional = userInformationRepository.findById(user.getUsername());

        if(userOptional.isEmpty()){
            //2. Hash password
            user.setStoredSalt(BCrypt.gensalt(10));
            user.setPassword(BCrypt.hashpw(user.getPassword(), user.getStoredSalt()));
            //3. Store password
            userInformationRepository.save(user);
        } else{
            throw new IllegalStateException("Username is already registered");
        }


    }
}
