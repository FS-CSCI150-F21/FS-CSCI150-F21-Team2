package com.smrtgrdyn.smrtgrdyn.User.Session;


import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@RestController
public class UserSessionController {


    private final UserLoginService userLoginService;

    @Autowired
    public UserSessionController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @RequestMapping("/api/v1/user_session/login")
    public void userLogin(HttpServletRequest request, @RequestBody User user){

        try{
            userLoginService.loginUser(request, user);
        }catch(IllegalStateException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Login", e);
        }
    }


    @RequestMapping("api/v1/user_session/logout")
    public void userLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if(session != null){
             session.invalidate();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No User Logged In");
        }


    }
}
