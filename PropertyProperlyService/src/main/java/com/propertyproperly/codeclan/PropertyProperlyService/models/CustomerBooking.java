package com.propertyproperly.codeclan.PropertyProperlyService.models;

import java.util.Date;

public class CustomerBooking extends Booking {

    private Customer customer;

    public CustomerBooking(Date startDate, Date endDate, BookableItem bookableItem, Customer customer) {
        super(startDate, endDate, bookableItem);
        this.customer = customer;
    }

    public CustomerBooking(Date startDate, Date endDate, BookableItem bookableItem) {
        super(startDate, endDate, bookableItem);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
