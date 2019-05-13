package com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItems;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import com.propertyproperly.codeclan.PropertyProperlyService.projections.EmbedBookableItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = EmbedBookableItem.class)
public interface BookableItemRepository extends JpaRepository<BookableItem, Long> {
}
