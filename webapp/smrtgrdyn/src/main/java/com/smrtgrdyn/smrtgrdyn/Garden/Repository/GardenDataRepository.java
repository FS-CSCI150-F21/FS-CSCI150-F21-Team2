package com.smrtgrdyn.smrtgrdyn.Garden.Repository;

import com.smrtgrdyn.smrtgrdyn.Garden.Sensor.GardenSensorData;
import com.smrtgrdyn.smrtgrdyn.Garden.Sensor.GardenSensorDataId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


/* GardenSensorDataId is a Composite ID class used for this repository
* This allows a single garden to have multiple entries
* And allows multiple entries at the same time without loss
* of specification*/

@Repository
public interface GardenDataRepository extends CrudRepository<GardenSensorData, GardenSensorDataId> {


    @Query("SELECT DISTINCT (g) FROM GardenSensorData g WHERE g.timestamp = (SELECT Max(g.timestamp) FROM GardenSensorData g WHERE g.gardenId = :gardenId)")
    List<GardenSensorData> findLatestEntryByGardenId(@Param("gardenId") String gardenId);

    List<GardenSensorData> findByGardenIdAndTimestampBetween(String gardenId, Timestamp start, Timestamp end);
}