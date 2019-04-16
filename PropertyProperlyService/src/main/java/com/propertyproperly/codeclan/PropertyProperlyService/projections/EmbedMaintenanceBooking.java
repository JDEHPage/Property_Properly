package com.propertyproperly.codeclan.PropertyProperlyService.projections;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import com.propertyproperly.codeclan.PropertyProperlyService.models.MaintenanceBooking;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedMaintenanceBooking", types = MaintenanceBooking.class)
public interface EmbedMaintenanceBooking {

    Long getId();
    String getStartDate();
    String getEndDate();
    boolean isstatus();
    boolean isCheckinStatus();
    String getNotes();
    List<BookableItem> getBookableItems();

    String getType();
}
