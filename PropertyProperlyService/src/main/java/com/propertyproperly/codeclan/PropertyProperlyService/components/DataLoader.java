package com.propertyproperly.codeclan.PropertyProperlyService.components;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Amenity;
import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItemType;
import com.propertyproperly.codeclan.PropertyProperlyService.models.PaymentOption;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.AmenityRepository;
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

    @Autowired
    AmenityRepository amenityRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {
        PaymentOption creditCard = new PaymentOption( "credit card");
        paymentOptionRepository.save(creditCard);

        BookableItemType singleRoom = new BookableItemType("Single Room");
        bookableItemTypeRepository.save(singleRoom);

        Amenity ensuiteBathroom = new Amenity("Ensuite Bathroom");
        amenityRepository.save(ensuiteBathroom);

        BookableItem room101 = new BookableItem( singleRoom, 1, 50);
        room101.addPaymentOption(creditCard);
        room101.addAmenity(ensuiteBathroom);
        bookableItemRepository.save(room101);


    }
}
