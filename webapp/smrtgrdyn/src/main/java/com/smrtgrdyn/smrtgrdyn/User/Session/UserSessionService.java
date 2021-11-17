package com.smrtgrdyn.smrtgrdyn.User.Session;

import com.smrtgrdyn.smrtgrdyn.Garden.Repository.UserInformationRepository;
import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class UserSessionService {


    private final UserInformationRepository userInformationRepository;

    @Autowired
    public UserSessionService(UserInformationRepository userInformationRepository) {
        this.userInformationRepository = userInformationRepository;
    }

    public void loginUser(HttpServletRequest request, User user) throws IllegalStateException{
        if (isUserVerified(user)){
            startSession(request, user.getUsername());
        }
    }

    private boolean isUserVerified(User user){

        Optional<User> userOptional = userInformationRepository.findById(user.getUsername());

        if(userOptional.isPresent()){

            String plainTextPassword = user.getPassword();
            String hashedPassword = BCrypt.hashpw(user.getPassword(), userOptional.get().getStoredSalt());

            if(BCrypt.checkpw(plainTextPassword, hashedPassword)) {
                return true;
            }
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Username or Password");

    }

    private void startSession(HttpServletRequest request, String username){

        HttpSession session = request.getSession(false);
        //a null session denotes that nobody is logged in yet
        if(session == null){
            session = request.getSession();
            session.setAttribute("username", username);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Someone is already Logged In");
        }
    }

    public void setDefaultGarden(String gardenId, String username){

        Optional<User> optionalUser = userInformationRepository.findById(username);

        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Not Found");
        }

        if(optionalUser.get().getRegisteredGardens().contains(gardenId)){
            User user = optionalUser.get();
            user.setDefaultGarden(gardenId);
            userInformationRepository.save(user);
        }
    }

    public String getDefaultGarden(String username){
        Optional<User> optionalUser = userInformationRepository.findById(username);

        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Not Found");
        }

        return optionalUser.get().getDefaultGarden();
    }

}
