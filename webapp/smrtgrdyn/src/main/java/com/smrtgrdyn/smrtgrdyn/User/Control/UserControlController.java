package com.smrtgrdyn.smrtgrdyn.User.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserControlController {

    private final UserControlService service;

    @Autowired
    public UserControlController(UserControlService service) {
        this.service = service;
    }


    @PostMapping("api/v1/control")
    public void sendCommand(HttpServletRequest request, @RequestBody ControlRequest controlRequest){

        // Ensure Valid Login
        HttpSession session = request.getSession(false);

        //a null session denotes that nobody is logged in yet
        if(session == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No User is logged in");
        }else{
           session = request.getSession();
           String username = (String) session.getAttribute("username");

           //Then send signal
           service.sendControlSignal(controlRequest, username);
        }

    }


}
