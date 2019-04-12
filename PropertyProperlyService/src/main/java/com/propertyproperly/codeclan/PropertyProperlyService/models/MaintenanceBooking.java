package com.propertyproperly.codeclan.PropertyProperlyService.models;

public class MaintenanceBooking extends Booking {

    private String type;

    public MaintenanceBooking(String startDate, String endDate, BookableItem bookableItem, Boolean ongoing, String type) {
        super(startDate, endDate, bookableItem, ongoing);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
