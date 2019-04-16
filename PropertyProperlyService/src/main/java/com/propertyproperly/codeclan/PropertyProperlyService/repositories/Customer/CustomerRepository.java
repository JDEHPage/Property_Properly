package com.propertyproperly.codeclan.PropertyProperlyService.repositories.Customer;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Customer;
import com.propertyproperly.codeclan.PropertyProperlyService.projections.EmbedCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@Repository
@RepositoryRestResource(excerptProjection = EmbedCustomer.class)
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
