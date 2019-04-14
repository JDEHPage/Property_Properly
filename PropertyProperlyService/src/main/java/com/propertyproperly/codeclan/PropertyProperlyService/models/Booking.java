package com.propertyproperly.codeclan.PropertyProperlyService.models;

import java.util.Date;

public abstract class Booking {

    private Date startDate;
    private Date endDate;
    private BookableItem bookableItem;
    private boolean ongoing;
    private String notes;

    public Booking(Date startDate, Date endDate, BookableItem bookableItem) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookableItem = bookableItem;
        this.ongoing = false;
        this.notes = "";
    }

    public Booking() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BookableItem getBookableItem() {
        return bookableItem;
    }

    public void setBookableItem(BookableItem bookableItem) {
        this.bookableItem = bookableItem;
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
}
