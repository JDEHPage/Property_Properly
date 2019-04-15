package com.propertyproperly.codeclan.PropertyProperlyService.Controllers;

import com.propertyproperly.codeclan.PropertyProperlyService.repositories.MaintenanceBooking.MaintenanceBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/maintenance_bookings")
public class MaintenanceBookingController {

    @Autowired
    MaintenanceBookingRepository maintenanceBookingRepository;
}
