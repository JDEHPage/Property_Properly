package com.propertyproperly.codeclan.PropertyProperlyService.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CustomerBooking extends Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean paid;
    private Customer customer;

    public CustomerBooking(String startDate, String endDate, BookableItem bookableItem, Boolean ongoing, Boolean paid, Customer customer) {
        super(startDate, endDate, bookableItem, ongoing);
        this.paid = paid;
        this.customer = customer;
    }

    public CustomerBooking() {
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
