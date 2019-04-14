package com.propertyproperly.codeclan.PropertyProperlyService.Repositories.BookableItemType;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
}
