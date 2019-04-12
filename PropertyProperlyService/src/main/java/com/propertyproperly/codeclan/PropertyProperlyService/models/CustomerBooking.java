package com.propertyproperly.codeclan.PropertyProperlyService.models;

public class CustomerBooking extends Booking {

    private Boolean paid;
    private Customer customer;

    public CustomerBooking(String startDate, String endDate, BookableItem bookableItem, Boolean ongoing, Boolean paid) {
        super(startDate, endDate, bookableItem, ongoing);
        this.paid = paid;
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
