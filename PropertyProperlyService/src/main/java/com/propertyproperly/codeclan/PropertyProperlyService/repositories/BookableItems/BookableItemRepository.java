package com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItems;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookableItemRepository extends JpaRepository<BookableItem, Long> {
}
