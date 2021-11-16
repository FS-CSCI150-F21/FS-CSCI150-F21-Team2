package com.smrtgrdyn.smrtgrdyn.User.Registration;

import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@RestController
@RequestMapping("api/v1/user_registration")
public class UserRegistrationController {


    private final UserRegistrationService userRegistrationService;

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping
    public void registerUser(HttpServletRequest request, HttpServletResponse response, @RequestBody User user) {
        try {
            userRegistrationService.registerUser(user);
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            response.setStatus(200);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
