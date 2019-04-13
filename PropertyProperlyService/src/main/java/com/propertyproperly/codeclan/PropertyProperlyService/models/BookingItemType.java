package com.propertyproperly.codeclan.PropertyProperlyService.models;

import java.util.List;

public class BookingItemType {

    private String name;
    private List<BookableItem> bookableItems;

    public BookingItemType(String name, List<BookableItem> bookableItems) {
        this.name = name;
        this.bookableItems = bookableItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookableItem> getBookableItems() {
        return bookableItems;
    }

    public void setBookableItems(List<BookableItem> bookableItems) {
        this.bookableItems = bookableItems;
    }
}
