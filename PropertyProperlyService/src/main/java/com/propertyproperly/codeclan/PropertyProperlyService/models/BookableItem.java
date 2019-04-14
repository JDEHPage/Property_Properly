package com.propertyproperly.codeclan.PropertyProperlyService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

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

//    @JsonIgnoreProperties("bookableItems")
//    @ManyToMany
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinTable(
//            name = "bookableitems_paymentoptions",
//            joinColumns = {@JoinColumn(name = "bookableitem_id", nullable = false, updatable = false)},
//            inverseJoinColumns = {@JoinColumn(name = "paymentoption_id", nullable = false, updatable = false)}
//    )
//    private List<PaymentOption> paymentOptions;

//    @JsonIgnoreProperties("bookableItems")
//    @ManyToMany
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinTable(
//            name = "bookableitems_amenities",
//            joinColumns = {@JoinColumn(name = "bookableitem_id", nullable = false, updatable = false)},
//            inverseJoinColumns = {@JoinColumn(name = "amenity_id", nullable = false, updatable = false)}
//    )
//    private List<Amenity> amenities;

    @JsonIgnoreProperties("bookableItems")
    @ManyToOne
    @JoinColumn(name = "bookingitemtype_id", nullable = false)
    private BookingItemType bookingItemType;

    @Column(name = "clean")
    private Boolean clean;

//    @JsonIgnoreProperties("bookableItems")
//    @ManyToMany
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinTable(
//            name = "bookableitems_bookings",
//            joinColumns = {@JoinColumn(name = "bookableitem_id", nullable = false, updatable = false)},
//            inverseJoinColumns = {@JoinColumn(name = "booking_id", nullable = false, updatable = false)}
//    )
//    private List<Booking> bookings;

    public BookableItem(String name, int capacity, int rate, BookingItemType bookingItemType, Boolean clean) {
        this.name = name;
        this.capacity = capacity;
        this.rate = rate;
        this.bookingItemType = bookingItemType;
        this.clean = clean;
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

//    public List<PaymentOption> getPaymentOptions() {
//        return paymentOptions;
//    }
//
//    public void setPaymentOptions(List<PaymentOption> paymentOptions) {
//        this.paymentOptions = paymentOptions;
//    }
//
//    public List<Amenity> getAmenities() {
//        return amenities;
//    }
//
//    public void setAmenities(List<Amenity> amenities) {
//        this.amenities = amenities;
//    }

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

//    public List<Booking> getBookings() {
//        return bookings;
//    }
//
//    public void setBookings(List<Booking> bookings) {
//        this.bookings = bookings;
//    }
}