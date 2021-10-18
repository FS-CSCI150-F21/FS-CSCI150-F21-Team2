package com.smrtgrdyn.smrtgrdyn.Garden.Registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smrtgrdyn.smrtgrdyn.Garden.GardenInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController("api/v1/garden-registration")
public class GardenRegistrationController {


    @Autowired
    GardenRegistrationService service;

    @PostMapping
    UUID registrationRequest(HttpServletRequest servletRequest, @JsonProperty GardenRegistrationRequest registrationRequest){


        // Save the pairing request pi id and username
        return service.requestRegistration(servletRequest, registrationRequest);
    }
}
