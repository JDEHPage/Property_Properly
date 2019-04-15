package com.propertyproperly.codeclan.PropertyProperlyService.repositories.Amenities;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AmenityRepository extends JpaRepository<Amenity, Long> {
}
