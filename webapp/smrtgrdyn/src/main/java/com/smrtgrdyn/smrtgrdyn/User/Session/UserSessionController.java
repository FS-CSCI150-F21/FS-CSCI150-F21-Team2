package com.smrtgrdyn.smrtgrdyn.User.Session;


import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@RestController
public class UserSessionController {


    private final UserSessionService userSessionService;

    @Autowired
    public UserSessionController(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    @RequestMapping("/api/v1/user_session/login")
    @PostMapping
    public void userLogin(HttpServletRequest request, HttpServletResponse response, @RequestBody User user){

        try{
            userSessionService.loginUser(request, user);
            response.sendRedirect(request.getContextPath() + "/dashboard.html");
        }catch(IllegalStateException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Login", e);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error on Redirect", e);
        }
    }


    @RequestMapping("api/v1/user_session/logout")
    @PostMapping
    public void userLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if(session != null){
             session.invalidate();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No User Logged In");
        }


    }

    @RequestMapping("api/v1/user_session/setDefault")
    @PostMapping
    public void setDefaultGarden(HttpServletRequest request, @RequestParam("gardenId") String gardenId){
        HttpSession session = request.getSession(false);

        if(session != null){
            session = request.getSession();
            String username = session.getAttribute("username").toString();
            userSessionService.setDefaultGarden(gardenId, username);
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No User Logged In");
        }
    }

    @RequestMapping("api/v1/user_session/default_garden")
    @GetMapping
    public String getUserData(HttpServletRequest request){
        HttpSession session = request.getSession(false);

        if(session != null){
            session = request.getSession();
            String username = session.getAttribute("username").toString();
            return userSessionService.getDefaultGarden(username);
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No User Logged In");
        }
    }
}
