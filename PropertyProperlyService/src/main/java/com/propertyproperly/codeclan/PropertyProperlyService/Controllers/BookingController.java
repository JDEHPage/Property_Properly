package com.propertyproperly.codeclan.PropertyProperlyService.Controllers;

import com.propertyproperly.codeclan.PropertyProperlyService.repositories.Booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;
}
