package com.smrtgrdyn.smrtgrdyn.Garden.Registration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenRegistrationRequestRepository extends CrudRepository<GardenRegistrationRequest, String> {
}
