package com.propertyproperly.codeclan.PropertyProperlyService.projections;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItemType;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedBookableItemType", types = BookableItemType.class)
public interface EmbedBookableItemType {
    Long getId();
    String getName();
    List<BookableItem> getBookableItems();
}
