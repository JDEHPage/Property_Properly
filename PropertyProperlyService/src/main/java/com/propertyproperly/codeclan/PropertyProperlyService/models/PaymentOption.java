package com.propertyproperly.codeclan.PropertyProperlyService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "payment_options")
public class PaymentOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column ( name = "name" )
    private String name;

    @Column ( name = "description" )
    private String description;

    @JsonIgnoreProperties("paymentOptions")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @JoinTable(
            name = "bookableItems_paymentOptions",
            joinColumns = {@JoinColumn( name = "payment_option_id", updatable = false)},
            inverseJoinColumns = {@JoinColumn( name = "bookable_item_id", updatable = false)}
    )
    private List<BookableItem> bookableItems;

    public PaymentOption(String name) {

        this.name = name;
        this.description = "";
        this.bookableItems = new ArrayList<BookableItem>();
    }

    public PaymentOption() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BookableItem> getBookableItems() {
        return bookableItems;
    }

    public void setBookableItems(List<BookableItem> bookableItems) {
        this.bookableItems = bookableItems;
    }
}
