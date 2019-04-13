package com.propertyproperly.codeclan.PropertyProperlyService.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MaintenanceBooking extends Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    public MaintenanceBooking(String startDate, String endDate, BookableItem bookableItem, Boolean ongoing, String type) {
        super(startDate, endDate, bookableItem, ongoing);
        this.type = type;
    }

    public MaintenanceBooking() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
