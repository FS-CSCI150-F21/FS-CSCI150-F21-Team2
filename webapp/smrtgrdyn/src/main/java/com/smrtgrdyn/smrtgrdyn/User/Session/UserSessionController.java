package com.smrtgrdyn.smrtgrdyn.User.Session;


import com.smrtgrdyn.smrtgrdyn.Garden.GardenName.GardenName;
import com.smrtgrdyn.smrtgrdyn.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


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
            return;
        }catch(IllegalStateException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Login", e);
        }
    }


    @RequestMapping("api/v1/user_session/logout")
    @GetMapping
    public void userLogout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if(session != null){
            session.setAttribute("username", "");
            session.invalidate();
        }
    }


    @RequestMapping("api/v1/user_session/setDefault")
    @PostMapping
    public void setDefaultGarden(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("gardenId") String gardenId){
        HttpSession session = request.getSession(false);

        if(session != null){
            session = request.getSession();

            if(username.equals(session.getAttribute("username").toString())){
                userSessionService.setDefaultGarden(gardenId, username);
            }

        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No User Logged In");
        }
    }

    @RequestMapping("api/v1/user_session/default_garden")
    @GetMapping
    public GardenName getDefaultGarden(HttpServletRequest request, @RequestParam("username") String username){
        HttpSession session = request.getSession(false);

        if(session != null){
            session = request.getSession();
            if(username.equals(session.getAttribute("username").toString())){
                return userSessionService.getDefaultGarden(username);
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid User");
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No User Logged In");
        }
    }

    @RequestMapping("api/v1/user_session/get_gardens")
    @GetMapping
    public List<GardenName> getUsersGardens(HttpServletRequest request, @RequestParam("username") String username){
        HttpSession session = request.getSession(false);

        if(session != null){
            session = request.getSession();
            if(username.equals(session.getAttribute("username").toString())){
                return userSessionService.getUsersGardens(username);
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid User");
        }
        else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No User Logged In");
        }
    }


}
