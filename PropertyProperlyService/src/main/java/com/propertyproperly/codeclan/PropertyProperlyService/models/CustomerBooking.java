package com.propertyproperly.codeclan.PropertyProperlyService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "customer_bookings")
public class CustomerBooking extends Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties("bookableItems")
    @ManyToOne
    @JoinColumn( name = "bookable_item_id", nullable = true)
    private BookableItem bookableItem;

    @JsonIgnoreProperties("customerBookings")
    @ManyToOne
    @JoinColumn( name = "customer_id", nullable = false)
    private Customer customer;

    public CustomerBooking(Date startDate, Date endDate, BookableItem bookableItem, Customer customer) {
        super(startDate, endDate);
        this.bookableItem = bookableItem;
        this.customer = customer;

        customer.addBooking(this);
    }

    public CustomerBooking() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BookableItem getBookableItem() {
        return bookableItem;
    }

    public void setBookableItem(BookableItem bookableItem) {
        this.bookableItem = bookableItem;
    }
}
