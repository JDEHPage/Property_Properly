package com.propertyproperly.codeclan.PropertyProperlyService.projections;

import com.propertyproperly.codeclan.PropertyProperlyService.models.*;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedBookableItem", types = BookableItem.class)
public interface EmbedBookableItem {
    Long getId();
    String getName();
    BookableItemType getType();
    int getCapacity();
    int getRate();
    boolean isClean();
    List<PaymentOption> getPaymentOptions();
    List<Amenity> getAmenities();
    Property getProperty();
    List<Booking> getBookings();
    List<Booking> getBookingsNotInPast();
}
