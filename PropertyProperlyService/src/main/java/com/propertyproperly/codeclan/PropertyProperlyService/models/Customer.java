package com.propertyproperly.codeclan.PropertyProperlyService.models;

public class Customer {

    private String name;
    private String address;
    private String email;
    private int mobileNo;

    public Customer(String name, String address, String email, int mobileNo) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public Customer() {
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

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }
}
