package com.propertyproperly.codeclan.PropertyProperlyService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "bookingitemtypes")
public class BookingItemType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

//    @JsonIgnoreProperties("bookableItems")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @OneToMany(mappedBy = "bookingitemtype", fetch = FetchType.LAZY)
    private List<BookableItem> bookableItems;

    public BookingItemType(String name, List<BookableItem> bookableItems) {
        this.name = name;
        this.bookableItems = bookableItems;
    }

    public BookingItemType() {
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
