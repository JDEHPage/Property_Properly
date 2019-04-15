package com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItemType;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookableItemTypeRepository extends JpaRepository<BookableItemType, Long> {
}
