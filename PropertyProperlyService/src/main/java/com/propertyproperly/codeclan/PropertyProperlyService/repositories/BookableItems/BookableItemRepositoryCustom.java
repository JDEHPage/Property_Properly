package com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItems;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Booking;

import java.util.List;

public interface BookableItemRepositoryCustom {

    List<Booking> getBookingsNotInPast();
}
