package com.propertyproperly.codeclan.PropertyProperlyService.repositories;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookableItemRepository extends JpaRepository<BookableItem, Long> {
}
