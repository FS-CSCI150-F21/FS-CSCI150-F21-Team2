package com.smrtgrdyn.smrtgrdyn.Garden.Repository;

import com.smrtgrdyn.smrtgrdyn.Garden.Registration.GardenRegistrationRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GardenRegistrationRequestRepository extends CrudRepository<GardenRegistrationRequest, String> {

    @Query("SELECT g FROM GardenRegistrationRequest g WHERE g.gardenId = :gardenId")
    Optional<GardenRegistrationRequest> findByGardenId(@Param("gardenId") String gardenId);
}
