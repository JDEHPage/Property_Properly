package com.propertyproperly.codeclan.PropertyProperlyService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name=“BOOK_TYPE”)
@Table( name = "bookings" )
public abstract class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @JsonIgnoreProperties("bookings")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @JoinTable(
            name = "bookings_bookableItems",
            joinColumns = {@JoinColumn( name = "booking_id", updatable = false)},
            inverseJoinColumns = {@JoinColumn( name = "bookable_item_id", updatable = false)}
    )
    private List<BookableItem> bookableItems;

    @Column( name = "ongoing")
    private boolean ongoing;

    @Column(name = "notes")
    private String notes;

    public Booking(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookableItems = new ArrayList<BookableItem>();
        this.ongoing = false;
        this.notes = "";
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isOngoing() {
        return ongoing;
    }

    public void setOngoing(boolean ongoing) {
        this.ongoing = ongoing;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<BookableItem> getBookableItems() {
        return bookableItems;
    }

    public void setBookableItems(List<BookableItem> bookableItems) {
        this.bookableItems = bookableItems;
    }

    public void addBookableItem(BookableItem bookableItem){
        this.bookableItems.add(bookableItem);
    }
}
