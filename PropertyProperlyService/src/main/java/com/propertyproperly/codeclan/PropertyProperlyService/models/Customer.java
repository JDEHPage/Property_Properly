package com.propertyproperly.codeclan.PropertyProperlyService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "customers" )
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "name" )
    private String name;

    @Column( name = "address" )
    private String address;

    @Column( name = "email" )
    private String email;

    @Column( name = "mobile_number" )
    private String mobileNumber;

    @JsonIgnoreProperties("customer")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<CustomerBooking> bookings;

    public Customer(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobileNumber = null;
        this.bookings = new ArrayList<CustomerBooking>();
    }

    public Customer() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<CustomerBooking> getBookings() {
        return bookings;
    }

    public void setBookings(List<CustomerBooking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(CustomerBooking booking){
        this.bookings.add(booking);
    }

    public List<CustomerBooking> getBookingsNotInPast(){
        ArrayList<CustomerBooking> result = new ArrayList<CustomerBooking>();
        List<CustomerBooking> allBookings = this.getBookings();

        LocalDate today = LocalDate.now();

        // filter all bookings for those with an endDate < today
        for( CustomerBooking booking:allBookings ){

            if( booking.getEndDate().compareTo( today ) >= 0 ){
                result.add(booking);
            }
        }
        return result;
    }

}
