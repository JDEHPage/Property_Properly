package com.propertyproperly.codeclan.PropertyProperlyService.components;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItemType;
import com.propertyproperly.codeclan.PropertyProperlyService.models.PaymentOption;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItemRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItemTypeRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.PaymentOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookableItemTypeRepository bookableItemTypeRepository;

    @Autowired
    PaymentOptionRepository paymentOptionRepository;

    @Autowired
    BookableItemRepository bookableItemRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {
        PaymentOption creditCard = new PaymentOption( "credit card");
        paymentOptionRepository.save(creditCard);

        BookableItemType singleRoom = new BookableItemType("Single Room");
        bookableItemTypeRepository.save(singleRoom);

        BookableItem room101 = new BookableItem( singleRoom, 1, 50);
        bookableItemRepository.save(room101);


    }
}
