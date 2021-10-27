package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping("api/v1/garden_data_collection")
public class GardenDataController {

    private final GardenDataSaveService gardenDataSaveService;

    @Autowired
    public GardenDataController(GardenDataSaveService gardenDataSaveService) {
        this.gardenDataSaveService = gardenDataSaveService;
    }

    @PostMapping
    public void saveGardenData(@RequestBody GardenSensorData gardenSensorData){

        gardenDataSaveService.saveGardenData(gardenSensorData);

    }

    @GetMapping
    public GardenSensorData getLatestData(@RequestParam UUID gardenId){

        return gardenDataSaveService.getLatestData(gardenId);
    }


}
