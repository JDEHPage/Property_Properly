package com.propertyproperly.codeclan.PropertyProperlyService.projections;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Amenity;
import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedAmenity", types = Amenity.class)
public interface EmbedAmenity {
    Long getId();
    String getName();
    String getDescription();
    List<BookableItem> getBookableItems();
}
