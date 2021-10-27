package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
public class GardenDataController {

    private final GardenDataSaveService gardenDataSaveService;

    @Autowired
    public GardenDataController(GardenDataSaveService gardenDataSaveService) {
        this.gardenDataSaveService = gardenDataSaveService;
    }

    @PostMapping("api/v1/garden_data_collection/save")
    public void saveGardenData(@RequestBody GardenSensorData gardenSensorData){

        gardenDataSaveService.saveGardenData(gardenSensorData);

    }

    @GetMapping("api/v1/garden_data_collection/latest")
    public GardenSensorData getLatestData(@RequestBody GardenDataRequest request){

        return gardenDataSaveService.getLatestData(request);
    }

    @GetMapping("api/v1/garden_data_collection/range")
    public List getDataFromRange(@RequestBody GardenDataRequest request){

        return gardenDataSaveService.getDataFromRange(request);
    }


}
