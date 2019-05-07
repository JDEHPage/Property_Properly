package com.propertyproperly.codeclan.PropertyProperlyService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "maintenance_bookings")
public class MaintenanceBooking extends Booking {


    @Column( name = "type")
    private String type;

    public MaintenanceBooking(String startDate, Date endDate, String type) {
        super(startDate, endDate);
        this.type = type;
    }

    public MaintenanceBooking() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
