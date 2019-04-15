package com.propertyproperly.codeclan.PropertyProperlyService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "customer_bookings")
public class CustomerBooking extends Booking {


    @JsonIgnoreProperties("customerBookings")
    @ManyToOne
    @JoinColumn( name = "customer_id", nullable = false)
    private Customer customer;

    public CustomerBooking(String startDate, String endDate, Customer customer) {
        super(startDate, endDate);
        this.customer = customer;
    }

    public CustomerBooking() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
