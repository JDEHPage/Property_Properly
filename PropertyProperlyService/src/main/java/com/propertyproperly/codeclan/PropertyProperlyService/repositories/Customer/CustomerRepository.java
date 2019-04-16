package com.propertyproperly.codeclan.PropertyProperlyService.repositories.Customer;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Customer;
import com.propertyproperly.codeclan.PropertyProperlyService.projections.EmbedBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(excerptProjection = EmbedBooking.class)
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
