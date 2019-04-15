package com.propertyproperly.codeclan.PropertyProperlyService.components;

import com.propertyproperly.codeclan.PropertyProperlyService.models.*;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerBookingRepository customerBookingRepository;

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

        BookableItem room102 = new BookableItem( singleRoom, 1, 30);
        bookableItemRepository.save(room102);

        Property guestHouse = new Property("Suppa Duppa Guest House");
        guestHouse.addBookableItem(room101);
        guestHouse.addBookableItem(room102);
        propertyRepository.save(guestHouse);
        bookableItemRepository.save(room101);
        bookableItemRepository.save(room102);

        Customer customer1 = new Customer("Joe Bloggs", "Glasgow", "jblogs@gmail.com");
        customerRepository.save(customer1);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format( new Date()   );
        Date startDate = format.parse("2019-05-01");
        Date endDate = format.parse("2019-05-04");

        CustomerBooking booking1 = new CustomerBooking(startDate, endDate, room101, customer1);
        customerBookingRepository.save(booking1);

    }
}
