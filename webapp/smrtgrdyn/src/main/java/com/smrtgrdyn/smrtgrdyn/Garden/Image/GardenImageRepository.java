package com.smrtgrdyn.smrtgrdyn.Garden.Image;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenImageRepository extends CrudRepository<GardenImage, GardenImageId> {
}
