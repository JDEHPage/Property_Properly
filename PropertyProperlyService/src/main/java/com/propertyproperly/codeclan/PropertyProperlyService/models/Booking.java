package com.propertyproperly.codeclan.PropertyProperlyService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Booking {

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column( name = "ongoing")
    private boolean ongoing;

    @Column(name = "notes")
    private String notes;

    public Booking(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
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
