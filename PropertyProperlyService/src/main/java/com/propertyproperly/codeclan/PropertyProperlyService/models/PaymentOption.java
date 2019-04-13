package com.propertyproperly.codeclan.PropertyProperlyService.models;

public class PaymentOption {

    private String name;
    private String description;

    public PaymentOption(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public PaymentOption() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
