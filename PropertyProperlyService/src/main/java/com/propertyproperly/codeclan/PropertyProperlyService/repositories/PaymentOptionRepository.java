package com.propertyproperly.codeclan.PropertyProperlyService.repositories;

import com.propertyproperly.codeclan.PropertyProperlyService.models.PaymentOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOptionRepository extends JpaRepository<PaymentOption, Long> {
}
