package com.smrtgrdyn.smrtgrdyn.Garden;

import org.springframework.data.repository.CrudRepository;

/* GardenSensorDataId is a Composite ID class used for this repository
* This allows a single garden to have multiple entries
* And allows multiple entries at the same time without loss
* of specification*/

public interface GardenDataRepository extends CrudRepository<GardenSensorData, GardenSensorDataId> {
}
