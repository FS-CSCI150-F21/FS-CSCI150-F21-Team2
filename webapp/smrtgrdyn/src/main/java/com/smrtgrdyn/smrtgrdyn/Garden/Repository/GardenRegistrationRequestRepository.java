package com.smrtgrdyn.smrtgrdyn.Garden.Repository;

import com.smrtgrdyn.smrtgrdyn.Garden.Registration.GardenRegistrationRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GardenRegistrationRequestRepository extends CrudRepository<GardenRegistrationRequest, String> {

    @Query(value = "SELECT * FROM garden_registration_request WHERE garden_id = :gardenId", nativeQuery = true)
    Optional<GardenRegistrationRequest> findByGardenId(@Param("gardenId") UUID gardenId);
}
