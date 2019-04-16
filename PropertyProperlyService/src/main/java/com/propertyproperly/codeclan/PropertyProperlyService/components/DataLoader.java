package com.propertyproperly.codeclan.PropertyProperlyService.components;

import com.propertyproperly.codeclan.PropertyProperlyService.models.*;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.Amenities.AmenityRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItemType.BookableItemTypeRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItems.BookableItemRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.Customer.CustomerRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.CustomerBooking.CustomerBookingRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.MaintenanceBooking.MaintenanceBookingRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.PaymentOption.PaymentOptionRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.Property.PropertyRepository;
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

    @Autowired
    PropertyRepository propertyRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerBookingRepository customerBookingRepository;

    @Autowired
    MaintenanceBookingRepository maintenanceBookingRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {
        PaymentOption creditCard = new PaymentOption( "credit card");
        paymentOptionRepository.save(creditCard);

        Property guestHouse = new Property("Suppa Duppa Guest House");
        propertyRepository.save(guestHouse);

        BookableItemType singleRoom = new BookableItemType("Single Room");
        bookableItemTypeRepository.save(singleRoom);

        BookableItemType doubleRoom = new BookableItemType("Double");
        bookableItemTypeRepository.save(doubleRoom);

        Amenity ensuiteBathroom = new Amenity("Ensuite Bathroom");
        amenityRepository.save(ensuiteBathroom);

        BookableItem room101 = new BookableItem("Room 101", singleRoom, 1, 30, guestHouse);
        room101.addPaymentOption(creditCard);
        room101.addAmenity(ensuiteBathroom);
        bookableItemRepository.save(room101);

        BookableItem room102 = new BookableItem("Room 102", doubleRoom, 1, 50, guestHouse);
        bookableItemRepository.save(room102);


//        guestHouse.addBookableItem(room101);
//        guestHouse.addBookableItem(room102);
//        bookableItemRepository.save(room101);
//        bookableItemRepository.save(room102);
//        propertyRepository.save(guestHouse);

        Customer customer1 = new Customer("Joe Bloggs", "Glasgow", "jblogs@gmail.com");
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Shela Summers", "Berlin", "Shel11@gmail.com");
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Sam Winsel", "London", "sammey@gmail.com");
        customerRepository.save(customer3);


//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String dateString = format.format( new Date()   );
//        Date startDate = format.parse("2019-05-01");
//        Date endDate = format.parse("2019-05-04");

        CustomerBooking booking1 = new CustomerBooking("2019-05-01", "2019-05-04", customer1);
        customerBookingRepository.save(booking1);
        booking1.addBookableItem(room101);
        customerBookingRepository.save(booking1);

        CustomerBooking booking2 = new CustomerBooking("2019-05-01", "2019-05-04", customer2);
        customerBookingRepository.save(booking2);
        booking2.addBookableItem(room102);
        customerBookingRepository.save(booking2);

        CustomerBooking booking3 = new CustomerBooking("2019-06-01", "2019-06-04", customer3);
        customerBookingRepository.save(booking3);
        booking3.addBookableItem(room101);
        booking3.addBookableItem(room102);
        customerBookingRepository.save(booking3);

        MaintenanceBooking maintenanceBooking = new MaintenanceBooking("2019-05-20", "2019-05-21", "painting");
        maintenanceBookingRepository.save(maintenanceBooking);
        maintenanceBooking.addBookableItem(room102);
        maintenanceBookingRepository.save(maintenanceBooking);

    }
}
