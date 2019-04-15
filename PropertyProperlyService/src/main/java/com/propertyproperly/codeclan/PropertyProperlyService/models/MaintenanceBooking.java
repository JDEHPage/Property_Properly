package com.propertyproperly.codeclan.PropertyProperlyService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "maintenance_bookings")
public class MaintenanceBooking extends Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "type")
    private String type;

    @JsonIgnoreProperties("bookableItems")
    @ManyToOne
    @JoinColumn( name = "bookable_item_id", nullable = true)
    private BookableItem bookableItem;

    public MaintenanceBooking(Date startDate, Date endDate, BookableItem bookableItem, String type) {
        super(startDate, endDate);
        this.type = type;
        this.bookableItem = bookableItem;
    }

    public MaintenanceBooking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
