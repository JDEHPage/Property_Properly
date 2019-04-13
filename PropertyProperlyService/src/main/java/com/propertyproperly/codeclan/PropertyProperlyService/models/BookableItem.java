package com.propertyproperly.codeclan.PropertyProperlyService.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookableitems")
public class BookableItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "capacity")
    private int capacity;
    
    @Column(name = "rate")
    private int rate;
    
    @Column(name = "paymentOptions")
    private List<PaymentOption> paymentOption;
    
    @Column(name = "amenities")
    private List<Amenity> amenities;
    
    
    private BookingItemType bookingItemType;
    
    
    private Boolean clean;

    public BookableItem(String name, int capacity, int rate, BookingItemType bookingItemType, Boolean clean) {
        this.name = name;
        this.capacity = capacity;
        this.rate = rate;
        this.bookingItemType = bookingItemType;
        this.clean = clean;
        this.amenities = new ArrayList<>();
        this.paymentOption = new ArrayList<>();
    }

    public BookableItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public List<PaymentOption> getpaymentOption() {
        return paymentOption;
    }

    public void setpaymentOption(List<PaymentOption> paymentOption) {
        this.paymentOption = paymentOption;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public BookingItemType getBookingItemType() {
        return bookingItemType;
    }

    public void setBookingItemType(BookingItemType bookingItemType) {
        this.bookingItemType = bookingItemType;
    }

    public Boolean getClean() {
        return clean;
    }

    public void setClean(Boolean clean) {
        this.clean = clean;
    }
}