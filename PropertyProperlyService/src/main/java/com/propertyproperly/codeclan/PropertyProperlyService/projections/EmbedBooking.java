package com.propertyproperly.codeclan.PropertyProperlyService.projections;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Booking;
import com.propertyproperly.codeclan.PropertyProperlyService.models.CustomerBooking;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "embedBooking", types = Booking.class)
public interface EmbedBooking {
    String getStartDate();
    String getEndDate();
    boolean isOngoing();

}
