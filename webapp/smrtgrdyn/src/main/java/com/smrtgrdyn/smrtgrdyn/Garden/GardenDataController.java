package com.smrtgrdyn.smrtgrdyn.Garden;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/garden-data-collection")
public class GardenDataController {

    @PostMapping
    public void saveGardenData(@Valid @RequestBody GardenSensorSaveDataRequest gardenSensorSaveDataRequest){

    }
}
