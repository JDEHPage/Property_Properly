package com.propertyproperly.codeclan.PropertyProperlyService.projections;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import com.propertyproperly.codeclan.PropertyProperlyService.models.Property;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedProperty", types = Property.class)
public interface EmbedProperty {
    Long getId();
    String getName();
    List<BookableItem> getBookableItems();
}
