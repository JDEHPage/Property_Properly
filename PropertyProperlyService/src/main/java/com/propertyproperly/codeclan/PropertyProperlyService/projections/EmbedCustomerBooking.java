package com.propertyproperly.codeclan.PropertyProperlyService.projections;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import com.propertyproperly.codeclan.PropertyProperlyService.models.Customer;
import com.propertyproperly.codeclan.PropertyProperlyService.models.CustomerBooking;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;
import java.util.List;

@Projection(name = "embedCustomerBooking", types = CustomerBooking.class)
public interface EmbedCustomerBooking {

    Long getId();
    String getStartDate();
    LocalDate getEndDate();
    boolean isstatus();
    boolean isCheckinStatus();
    String getNotes();
    List<BookableItem> getBookableItems();

    Customer getCustomer();

}
