package com.propertyproperly.codeclan.PropertyProperlyService.repositories.Property;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Property;
import com.propertyproperly.codeclan.PropertyProperlyService.projections.EmbedProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@Repository
@RepositoryRestResource(excerptProjection = EmbedProperty.class)
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
