package com.propertyproperly.codeclan.PropertyProperlyService.Repositories.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerRepository, Long> {
}
