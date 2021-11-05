package com.smrtgrdyn.smrtgrdyn.User.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1/control")
public class UserControlController {

    private final UserControlService service;

    @Autowired
    public UserControlController(UserControlService service) {
        this.service = service;
    }


    @PostMapping
    public void sendCommand(@RequestParam("control_signal") String controlSignal){

        service.sendControlSignal(controlSignal);
    }
}
