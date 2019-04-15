package com.propertyproperly.codeclan.PropertyProperlyService.repositories;

import com.propertyproperly.codeclan.PropertyProperlyService.models.CustomerBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerBookingRepository extends JpaRepository<CustomerBooking, Long> {
}
