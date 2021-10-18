package com.smrtgrdyn.smrtgrdyn.Garden.Registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smrtgrdyn.smrtgrdyn.Garden.GardenInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/garden_registration")
public class GardenRegistrationController {



    private final GardenRegistrationService service;

    @Autowired
    public GardenRegistrationController(GardenRegistrationService service){
        this.service = service;
    }

    @PostMapping
    public UUID registrationRequest(HttpServletRequest servletRequest, @RequestBody GardenRegistrationRequest registrationRequest){


        // Save the pairing request pi id and username
        return service.requestRegistration(servletRequest, registrationRequest);
    }

    @GetMapping
    public GardenRegistrationRequest endpointTest(){
        return new GardenRegistrationRequest("12312313", "Ryan1Up");
    }
}
