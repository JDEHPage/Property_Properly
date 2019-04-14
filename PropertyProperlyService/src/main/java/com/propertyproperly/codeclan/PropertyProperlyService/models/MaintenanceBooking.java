//package com.propertyproperly.codeclan.PropertyProperlyService.models;
//
//import org.springframework.stereotype.Component;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
////@DiscriminatorValue("M")
//@Table(name="MAINTENANCEBOOKINGS")
//public class MaintenanceBooking extends Booking {
//
//    @Column
//    private String type;
//
//    public MaintenanceBooking(String startDate, String endDate, List<Room> bookableItems, Boolean ongoing, String type) {
//        super(startDate, endDate, bookableItems, ongoing);
//        this.type = type;
//    }
//
//    public MaintenanceBooking() {
//    }
//
//    public String getRType() {
//        return type;
//    }
//
//    public void setRType(String type) {
//        this.type = type;
//    }
//}
