package com.propertyproperly.codeclan.PropertyProperlyService.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private List<BookableItem> bookableItems;

    public Property(String name) {
        this.name = name;
        this.bookableItems = new ArrayList<>();
    }

    public Property() {
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

    public void addBooking(BookableItem bookableItem){
        this.bookableItems.add(bookableItem);
    }
}
