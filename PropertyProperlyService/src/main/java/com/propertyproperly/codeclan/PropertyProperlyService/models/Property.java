package com.propertyproperly.codeclan.PropertyProperlyService.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    private List<BookingItemType> bookingItemTypes;

    public Property(String name) {
        this.name = name;
        this.bookingItemTypes = new ArrayList<BookingItemType>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookingItemType> getBookingItemTypes() {
        return bookingItemTypes;
    }

    public void setBookingItemTypes(List<BookingItemType> bookingItemTypes) {
        this.bookingItemTypes = bookingItemTypes;
    }
}
