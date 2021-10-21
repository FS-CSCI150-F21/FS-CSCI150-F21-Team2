package com.smrtgrdyn.smrtgrdyn.User.Session;

import com.smrtgrdyn.smrtgrdyn.User.Registration.UserInformationRepository;
import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Optional;

@RestController
public class UserSessionController {


    private final UserInformationRepository userInformationRepository;

    @Autowired
    public UserSessionController(UserInformationRepository userInformationRepository) {
        this.userInformationRepository = userInformationRepository;
    }

    @RequestMapping("/api/v1/user_session/login")
    public void userLogin(HttpServletRequest request, @RequestBody User user){

        HttpSession session = request.getSession();


    }

    @RequestMapping("/api/v1/user_session/logout")
    public void userLogout(HttpServletRequest request, @RequestBody User user){

    }
}
