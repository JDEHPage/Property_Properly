package com.propertyproperly.codeclan.PropertyProperlyService.repositories;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
