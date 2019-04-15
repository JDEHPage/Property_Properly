package com.propertyproperly.codeclan.PropertyProperlyService.repositories.MaintenanceBooking;

import com.propertyproperly.codeclan.PropertyProperlyService.models.MaintenanceBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceBookingRepository extends JpaRepository<MaintenanceBooking, Long> {
}
