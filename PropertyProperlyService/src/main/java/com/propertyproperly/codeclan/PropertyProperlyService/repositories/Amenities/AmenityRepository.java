package com.propertyproperly.codeclan.PropertyProperlyService.repositories.Amenities;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Amenity;
import com.propertyproperly.codeclan.PropertyProperlyService.projections.EmbedAmenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


//@Repository
@RepositoryRestResource(excerptProjection = EmbedAmenity.class)
public interface AmenityRepository extends JpaRepository<Amenity, Long> {
}
