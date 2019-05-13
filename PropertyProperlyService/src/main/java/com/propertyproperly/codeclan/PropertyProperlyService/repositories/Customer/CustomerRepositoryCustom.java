package com.propertyproperly.codeclan.PropertyProperlyService.repositories.Customer;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Booking;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Booking> getBookingsNotInPast();
}
