package com.propertyproperly.codeclan.PropertyProperlyService.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
//@DiscriminatorValue("M")
@Table(name="MAINTENANCEBOOKINGS")
public class Maintenanceb extends Booking {

    @Column
    private String type;

    public Maintenanceb(String startDate, String endDate, String type) {
        super(startDate, endDate);
        this.type = type;
    }

    public Maintenanceb() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
