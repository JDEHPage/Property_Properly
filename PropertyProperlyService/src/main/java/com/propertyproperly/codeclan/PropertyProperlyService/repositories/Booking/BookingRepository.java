package com.propertyproperly.codeclan.PropertyProperlyService.repositories.Booking;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Booking;
import com.propertyproperly.codeclan.PropertyProperlyService.projections.EmbedBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(excerptProjection = EmbedBooking.class)
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
