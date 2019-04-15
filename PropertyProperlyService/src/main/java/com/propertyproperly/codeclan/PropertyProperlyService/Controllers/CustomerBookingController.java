package com.propertyproperly.codeclan.PropertyProperlyService.Controllers;

import com.propertyproperly.codeclan.PropertyProperlyService.repositories.Booking.BookingRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.CustomerBooking.CustomerBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer_bookings")
public class CustomerBookingController {

    @Autowired
    CustomerBookingRepository customerBookingRepository;
}
