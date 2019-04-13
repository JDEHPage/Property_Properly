package com.propertyproperly.codeclan.PropertyProperlyService.Repositories.BookableItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookableItemRepository extends JpaRepository<BookableItemRepository, Long> {
}
