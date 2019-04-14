package com.propertyproperly.codeclan.PropertyProperlyService.Repositories.MaintenanceBooking;


import com.propertyproperly.codeclan.PropertyProperlyService.models.Maintenanceb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenancebRepository extends JpaRepository<Maintenanceb, Long> {
}
