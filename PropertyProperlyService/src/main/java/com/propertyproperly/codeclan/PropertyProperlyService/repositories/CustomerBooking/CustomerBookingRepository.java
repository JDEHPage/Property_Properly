package com.propertyproperly.codeclan.PropertyProperlyService.repositories.CustomerBooking;

import com.propertyproperly.codeclan.PropertyProperlyService.models.CustomerBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerBookingRepository extends JpaRepository<CustomerBooking, Long> {
}
