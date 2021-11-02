package com.smrtgrdyn.smrtgrdyn.Garden.Repository;

import com.smrtgrdyn.smrtgrdyn.Garden.Sensor.GardenSensorData;
import com.smrtgrdyn.smrtgrdyn.Garden.Sensor.GardenSensorDataId;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/* GardenSensorDataId is a Composite ID class used for this repository
* This allows a single garden to have multiple entries
* And allows multiple entries at the same time without loss
* of specification*/

@Repository("garden_sensor_data")
public interface GardenDataRepository extends CrudRepository<GardenSensorData, GardenSensorDataId> {

    @Query(value = "SELECT * FROM garden_sensor_data" +
            " where timestamp = :timestamp",
            nativeQuery = true) //native query means to use native SQL
    Optional<GardenSensorData> selectGardenByTimestamp(@Param("timestamp") Timestamp timestamp);

    @Query( value = "SELECT MAX(timestamp) as timestamp FROM garden_sensor_data WHERE " +
                    "garden_id = :gardenId", nativeQuery = true)
    Optional<Timestamp> findLatestTimestampByGardenId(@Param("gardenId") UUID gardenId);


    default Optional<GardenSensorData> findLatestByGardenId(@Param("gardenId") UUID gardenId){
        Optional<Timestamp> optionalTimestamp = findLatestTimestampByGardenId(gardenId);
        findAll();
        Optional<GardenSensorData> data = findById(new GardenSensorDataId(gardenId,optionalTimestamp.get()));
        return data;
    }


    default List<GardenSensorData> findAllDataInRangeById(UUID gardenId, Timestamp start, Timestamp end){
        findAll();
        List<GardenSensorData> list = new ArrayList<>();
        for(GardenSensorData g : findAll()){
             if(g.getGardenId().equals(gardenId) && start.before(g.getTimestamp()) && end.after(g.getTimestamp())){
                 list.add(g);
             }
        }
        return list;
    }

    //This SHOULD do the same as the above, but returns nothing
    List<GardenSensorData> findByGardenIdAndTimestampBetween(UUID gardenId, Timestamp start, Timestamp end);


}
