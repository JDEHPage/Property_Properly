package com.propertyproperly.codeclan.PropertyProperlyService.repositories;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
