package com.smrtgrdyn.smrtgrdyn.Garden.Repository;

import com.smrtgrdyn.smrtgrdyn.Garden.Image.GardenImage;
import com.smrtgrdyn.smrtgrdyn.Garden.Image.GardenImageId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenImageRepository extends CrudRepository<GardenImage, GardenImageId> {
}
