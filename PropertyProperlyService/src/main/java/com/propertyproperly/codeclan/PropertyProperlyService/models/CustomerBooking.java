//package com.propertyproperly.codeclan.PropertyProperlyService.models;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
////@DiscriminatorValue("C")
//@Table(name="CUSTOMERBOOKINGS")
//public class CustomerBooking extends Booking {
//
//    @Column(name = "paid")
//    private Boolean paid;
//
//    @JsonIgnoreProperties("customerBookings")
//    @ManyToOne
//    @JoinColumn(name = "customer_id", nullable = false)
//    private Customer customer;
//
//    public CustomerBooking(String startDate, String endDate, List<BookableItem> bookableItems, Boolean ongoing, Boolean paid, Customer customer) {
//        super(startDate, endDate, bookableItems, ongoing);
//        this.paid = paid;
//        this.customer = customer;
//    }
//
//    public CustomerBooking() {
//    }
//
//    public Boolean getPaid() {
//        return paid;
//    }
//
//    public void setPaid(Boolean paid) {
//        this.paid = paid;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//}
