package com.smrtgrdyn.smrtgrdyn.Garden.Repository;

import com.smrtgrdyn.smrtgrdyn.Garden.Connection.GardenConnectionInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// GardenInformation is a Composite ID class for Garden Information
// This ensures specificity even if a garden has 2 registered users
// or a user has more than one garden.

@Repository
public interface GardenConnectionInformationRepository extends CrudRepository<GardenConnectionInformation, String> {

    //find connection information via username AND UUID

}
