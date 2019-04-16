package com.propertyproperly.codeclan.PropertyProperlyService.projections;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import com.propertyproperly.codeclan.PropertyProperlyService.models.PaymentOption;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedPaymentOption", types = PaymentOption.class)
public interface EmbedPaymentOption {
    Long getId();
    String getName();
    String getDescription();
    List<BookableItem> getBookableItems();
}
