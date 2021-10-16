package com.smrtgrdyn.smrtgrdyn.Garden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GardenDataSaveService {

    private final GardenDataRepository gardenDataRepository;

    @Autowired //This allows a dependency injection so we don't have to instantiate the repo
    public GardenDataSaveService(GardenDataRepository gardenDataRepository){
        this.gardenDataRepository = gardenDataRepository;
    }

    public void saveGardenData(GardenSensorSaveDataRequest request){
        /*
        * 1. Get Garden Sensor Data
        * 2. Verify Garden is Registered via GardenInformationRepo
        * 3. Store Garden Data*/
    }
}
