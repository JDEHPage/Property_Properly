package com.propertyproperly.codeclan.PropertyProperlyService.models;

import javax.persistence.*;

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

    public Customer(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobileNumber = null;
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
}
