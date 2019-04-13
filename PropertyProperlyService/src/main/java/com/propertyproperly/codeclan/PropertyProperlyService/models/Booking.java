package com.propertyproperly.codeclan.PropertyProperlyService.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "startdate")
    private String startDate;

    @Column(name = "enddate")
    private String endDate;





    private BookableItem bookableItem;

    @Column(name = "notes")
    private String notes;

    @Column(name = "ongoing")
    private Boolean ongoing;

    public Booking(String startDate, String endDate, BookableItem bookableItem, Boolean ongoing) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookableItem = bookableItem;
        this.ongoing = ongoing;
    }

    public Booking() {
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

    public BookableItem getBookableItem() {
        return bookableItem;
    }

    public void setBookableItem(BookableItem bookableItem) {
        this.bookableItem = bookableItem;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getOngoing() {
        return ongoing;
    }

    public void setOngoing(Boolean ongoing) {
        this.ongoing = ongoing;
    }
}
