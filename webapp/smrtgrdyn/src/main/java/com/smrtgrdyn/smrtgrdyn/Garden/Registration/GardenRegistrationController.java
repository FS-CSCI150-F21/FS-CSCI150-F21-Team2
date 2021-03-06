package com.smrtgrdyn.smrtgrdyn.Garden.Registration;


import com.smrtgrdyn.smrtgrdyn.Garden.GardenName.GardenName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class GardenRegistrationController {

    private final GardenRegistrationService service;

    @Autowired
    public GardenRegistrationController(GardenRegistrationService service){
        this.service = service;
    }

    @PostMapping
    @RequestMapping("api/v1/garden_registration/pi")
    public String openRegistrationRequest(HttpServletRequest servletRequest,
                                          @RequestBody GardenRegistrationRequest registrationRequest){

        // Save the pairing request pi id and username
        service.openRegistrationRequest(servletRequest, registrationRequest);

        System.out.println(registrationRequest.getGardenId()); // TODO Remove when done testing
        return registrationRequest.getGardenId();
    }

    @PostMapping
    @RequestMapping("api/v1/garden_registration/user")
    public String registrationConfirmationFromUser(HttpServletRequest servletRequest,
                                                 @RequestBody GardenRegistrationRequest request){

        //Get the session
        HttpSession session = servletRequest.getSession(false);
        //If someone logged in, continue to registration confirmation
        if(session != null){
            String username = (String) session.getAttribute("username");

            return service.confirmRegistration(username, request);

        }else{
            //Otherwise nobody is logged in, throw error
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not logged in");
        }
    }

    @PostMapping
    @RequestMapping("api/v1/garden_registration/name_garden")
    public void nameGarden(@RequestBody GardenName gardenName){

        service.setGardenName(gardenName);
    }

}
