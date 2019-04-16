package com.propertyproperly.codeclan.PropertyProperlyService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "bookable_items")
public class BookableItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "name" )
    private String name;

    @JsonIgnoreProperties("bookableItems")
    @ManyToOne
    @JoinColumn( name = "type_id", nullable = false )
    private BookableItemType type;

    @Column( name = "capacity" )
    private int capacity;

    @Column( name = "rate" )
    private int rate;

    @Column( name = "clean" )
    private boolean clean;

    @JsonIgnoreProperties("bookableItems")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "bookableItems_paymentOptions",
            joinColumns = {@JoinColumn( name = "bookable_item_id", updatable = false)},
            inverseJoinColumns = {@JoinColumn( name = "payment_option_id", updatable = false)}
    )
    private List<PaymentOption> paymentOptions;

    @JsonIgnoreProperties("bookableItems")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "bookableItems_amenities",
            joinColumns = {@JoinColumn( name = "bookable_item_id", updatable = false)},
            inverseJoinColumns = {@JoinColumn( name = "amenity_id", updatable = false)}
    )
    private List<Amenity> amenities;

    @JsonIgnoreProperties("bookableItems")
    @ManyToOne
    @JoinColumn( name = "property_id", nullable = false)
    private Property property;

    @JsonIgnoreProperties("bookableItems")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "bookings_bookableItems",
            joinColumns = {@JoinColumn( name = "bookable_item_id", updatable = false)},
            inverseJoinColumns = {@JoinColumn( name = "booking_id", updatable = false)}
    )
    private List<Booking> bookings;

    public BookableItem(String name, BookableItemType type, int capacity, int rate, Property property) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.rate = rate;
        this.clean = true;
        this.paymentOptions = new ArrayList<PaymentOption>();
        this.amenities = new ArrayList<Amenity>();
        this.bookings = new ArrayList<Booking>();
        this.property = property;
    }

    public BookableItem() {
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

    public BookableItemType getType() {
        return type;
    }

    public void setType(BookableItemType type) {
        this.type = type;
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

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public List<PaymentOption> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(List<PaymentOption> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public void addPaymentOption(PaymentOption paymentOption){
        this.paymentOptions.add(paymentOption);
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public void addAmenity(Amenity amenity){
        this.amenities.add(amenity);
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }
}
