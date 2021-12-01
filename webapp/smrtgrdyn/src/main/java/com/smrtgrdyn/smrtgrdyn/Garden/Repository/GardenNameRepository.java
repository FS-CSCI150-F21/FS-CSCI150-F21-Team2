package com.smrtgrdyn.smrtgrdyn.Garden.Repository;

import com.smrtgrdyn.smrtgrdyn.Garden.GardenName.GardenName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenNameRepository extends CrudRepository<GardenName, String> {
}
