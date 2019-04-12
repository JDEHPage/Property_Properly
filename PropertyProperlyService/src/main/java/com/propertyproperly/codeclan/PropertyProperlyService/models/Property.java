package com.propertyproperly.codeclan.PropertyProperlyService.models;

import java.util.ArrayList;
import java.util.List;

public class Property {

    private String name;
    private List<BookableItems> bookableItems;

    public Property(String name) {
        this.name = name;
        this.bookableItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookableItems> getBookableItems() {
        return bookableItems;
    }

    public void setBookableItems(List<BookableItems> bookableItems) {
        this.bookableItems = bookableItems;
    }

    public void addBooking(BookableItems bookableItems){
        this.bookableItems.add(bookableItems);
    }
}
