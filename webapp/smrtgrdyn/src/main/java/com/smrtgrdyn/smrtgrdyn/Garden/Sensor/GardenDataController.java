package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class GardenDataController {

    private final GardenDataSaveService gardenDataSaveService;

    @Autowired
    public GardenDataController(GardenDataSaveService gardenDataSaveService) {
        this.gardenDataSaveService = gardenDataSaveService;
    }

    @PostMapping("api/v1/garden_data_collection/save")
    public void saveGardenData(HttpServletRequest request, @RequestBody GardenSensorData gardenSensorData){

        gardenDataSaveService.saveGardenData(request, gardenSensorData);

    }

    @PostMapping("api/v1/garden_data_collection/latest")
    public GardenSensorData getLatestData(@RequestBody GardenDataRequest request){

        return gardenDataSaveService.getLatestData(request);
    }

    @PostMapping("api/v1/garden_data_collection/range")
    public List getDataFromRange(@RequestBody GardenDataRequest request){

        return gardenDataSaveService.getDataFromRange(request);
    }


}
