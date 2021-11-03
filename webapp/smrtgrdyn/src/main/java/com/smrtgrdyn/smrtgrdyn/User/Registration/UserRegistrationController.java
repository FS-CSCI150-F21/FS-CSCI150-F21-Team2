package com.smrtgrdyn.smrtgrdyn.User.Registration;

import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/user_registration")
public class UserRegistrationController {


    private final UserRegistrationService userRegistrationService;

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping
    public void registerUser(@RequestBody User user){

        userRegistrationService.registerUser(user);
    }

}
