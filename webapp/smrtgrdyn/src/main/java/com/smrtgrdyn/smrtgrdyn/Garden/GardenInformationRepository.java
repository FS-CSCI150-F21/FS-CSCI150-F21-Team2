package com.smrtgrdyn.smrtgrdyn.Garden;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.Table;
import java.util.UUID;

// GardenInformation is a Composite ID class for Garden Information
// This ensures specificity even if a garden has 2 registered users
// or a user has more than one garden.

public interface GardenInformationRepository extends CrudRepository<GardenInformation, UUID> {
}
