package com.propertyproperly.codeclan.PropertyProperlyService.Repositories.BookableItemType;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookingItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookableItemTypeRepository extends JpaRepository<BookingItemType, Long> {
}
