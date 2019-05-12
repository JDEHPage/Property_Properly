package com.propertyproperly.codeclan.PropertyProperlyService.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table( name = "maintenance_bookings")
public class MaintenanceBooking extends Booking {


    @Column( name = "type")
    private String type;

    public MaintenanceBooking(String startDate, LocalDate endDate, String type) {
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
