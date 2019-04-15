package com.propertyproperly.codeclan.PropertyProperlyService.projections;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import com.propertyproperly.codeclan.PropertyProperlyService.models.CustomerBooking;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "embedBookableItem", types = BookableItem.class)
public interface EmbedBookableItem {
    int getRate();
    boolean isClean();
    int getCapacity();

}
