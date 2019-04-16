package com.propertyproperly.codeclan.PropertyProperlyService.repositories.PaymentOption;

import com.propertyproperly.codeclan.PropertyProperlyService.models.PaymentOption;
import com.propertyproperly.codeclan.PropertyProperlyService.projections.EmbedPaymentOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


//@Repository
@RepositoryRestResource(excerptProjection = EmbedPaymentOption.class)
public interface PaymentOptionRepository extends JpaRepository<PaymentOption, Long> {
}
