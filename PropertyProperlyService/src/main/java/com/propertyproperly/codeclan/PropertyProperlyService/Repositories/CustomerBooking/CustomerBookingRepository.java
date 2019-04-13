package com.propertyproperly.codeclan.PropertyProperlyService.Repositories.CustomerBooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerBookingRepository extends JpaRepository<CustomerBookingRepository, Long> {
}
