package com.propertyproperly.codeclan.PropertyProperlyService.projections;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Customer;
import com.propertyproperly.codeclan.PropertyProperlyService.models.CustomerBooking;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedCustomer", types = Customer.class)
public interface EmbedCustomer {
    Long getId();
    String getName();
    String getAddress();
    String getEmail();
    String getMobileNumber();
    List<CustomerBooking> getBookings();

}
