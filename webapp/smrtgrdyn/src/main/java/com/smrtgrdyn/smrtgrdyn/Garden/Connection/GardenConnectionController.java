package com.smrtgrdyn.smrtgrdyn.Garden.Connection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api/v1/connection")
public class GardenConnectionController {



    private final GardenConnectionService service;

    @Autowired
    public GardenConnectionController(GardenConnectionService service) {
        this.service = service;
    }

    @PostMapping
    public void updateConnectionInfo(GardenConnectionInformation info){
        service.updateConnectionInformation(info);
    }

    @GetMapping
    public GardenConnectionInformation getConnectionInfo(HttpServletRequest request, @Param("gardenId") String gardenId){

        HttpSession session = request.getSession(false);

        if(session != null || session.getAttribute("username").toString() != ""){
            String username = session.getAttribute("username").toString();
            return service.getConnectionInformation(gardenId, username);
        }
        else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Session");
        }

    }
}
