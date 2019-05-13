package com.propertyproperly.codeclan.PropertyProperlyService.repositories.MaintenanceBooking;

import com.propertyproperly.codeclan.PropertyProperlyService.models.MaintenanceBooking;
import com.propertyproperly.codeclan.PropertyProperlyService.projections.EmbedMaintenanceBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = EmbedMaintenanceBooking.class)
public interface MaintenanceBookingRepository extends JpaRepository<MaintenanceBooking, Long> {
}
