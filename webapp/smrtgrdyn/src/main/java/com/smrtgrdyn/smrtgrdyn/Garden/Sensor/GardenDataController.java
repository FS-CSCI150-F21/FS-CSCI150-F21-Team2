package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/garden_data_collection")
public class GardenDataController {

    private final GardenDataSaveService gardenDataSaveService;

    @Autowired
    public GardenDataController(GardenDataSaveService gardenDataSaveService) {
        this.gardenDataSaveService = gardenDataSaveService;
    }

    @PostMapping
    public void saveGardenData(@Valid @RequestBody GardenSensorData gardenSensorData){

        System.out.println(gardenSensorData.toString());
        gardenDataSaveService.saveGardenData(gardenSensorData);

    }


}
