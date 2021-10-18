package com.smrtgrdyn.smrtgrdyn.User.Registration;

import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserVerificationService {

    private final UserInformationRepository userInformationRepository;

    @Autowired
    public UserVerificationService(UserInformationRepository userInformationRepository){
        this.userInformationRepository = userInformationRepository;
    }

    public boolean isUsernameValid(String username){
        //TODO Implement Username checking
        return false;
    }


    public boolean isUserVerified(User user){
        //TODO implement business logic to verify user is in system
        return false;
    }
}
