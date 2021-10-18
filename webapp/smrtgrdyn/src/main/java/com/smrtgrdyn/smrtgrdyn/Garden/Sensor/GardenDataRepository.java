package com.smrtgrdyn.smrtgrdyn.Garden.Sensor;

import com.smrtgrdyn.smrtgrdyn.Garden.Sensor.GardenSensorData;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Table;
import java.util.UUID;

/* GardenSensorDataId is a Composite ID class used for this repository
* This allows a single garden to have multiple entries
* And allows multiple entries at the same time without loss
* of specification*/


public interface GardenDataRepository extends CrudRepository<GardenSensorData, UUID> {
}
