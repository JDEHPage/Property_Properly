package com.propertyproperly.codeclan.PropertyProperlyService.repositories.CustomerBooking;

import com.propertyproperly.codeclan.PropertyProperlyService.models.CustomerBooking;
import com.propertyproperly.codeclan.PropertyProperlyService.projections.EmbedCustomerBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(excerptProjection = EmbedCustomerBooking.class)
//@Repository
public interface CustomerBookingRepository extends JpaRepository<CustomerBooking, Long> {
}
