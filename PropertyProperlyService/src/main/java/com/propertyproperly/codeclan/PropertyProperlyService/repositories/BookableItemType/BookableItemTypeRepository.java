package com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItemType;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItemType;
import com.propertyproperly.codeclan.PropertyProperlyService.projections.EmbedBookableItem;
import com.propertyproperly.codeclan.PropertyProperlyService.projections.EmbedBookableItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@Repository
@RepositoryRestResource(excerptProjection = EmbedBookableItemType.class)
public interface BookableItemTypeRepository extends JpaRepository<BookableItemType, Long> {
}
