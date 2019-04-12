package com.propertyproperly.codeclan.PropertyProperlyService.models;

import java.util.ArrayList;
import java.util.List;

public class BookableItem {

    private String name;
    private int capacity;
    private int rate;
    private List<BookingItemType> bookingItemTypes;
    boolean clean;

    public BookableItem(String name, int capacity, int rate, boolean clean) {
        this.name = name;
        this.capacity = capacity;
        this.rate = rate;
        this.bookingItemTypes = new ArrayList<>();
        this.clean = clean;
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

    public List<BookingItemType> getBookingItemTypes() {
        return bookingItemTypes;
    }

    public void setBookingItemTypes(List<BookingItemType> bookingItemTypes) {
        this.bookingItemTypes = bookingItemTypes;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }
}