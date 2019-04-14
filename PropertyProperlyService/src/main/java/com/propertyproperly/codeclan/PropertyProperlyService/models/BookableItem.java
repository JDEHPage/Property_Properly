package com.propertyproperly.codeclan.PropertyProperlyService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "bookable_items")
public class BookableItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties("bookableItems")
    @ManyToOne
    @JoinColumn( name = "type_id", nullable = false )
    private BookableItemType type;

    @Column( name = "capacity" )
    private int capacity;

    @Column( name = "rate" )
    private int rate;

    @Column( name = "clean" )
    private boolean clean;

    @JsonIgnoreProperties("bookableItems")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "bookableItems_paymentOptions",
            joinColumns = {@JoinColumn( name = "bookable_item_id", updatable = false)},
            inverseJoinColumns = {@JoinColumn( name = "payment_option_id", updatable = false)}
    )
    private List<PaymentOption> paymentOptions;

    public BookableItem(BookableItemType type, int capacity, int rate) {
        this.type = type;
        this.capacity = capacity;
        this.rate = rate;
        this.clean = true;
    }

    public BookableItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookableItemType getType() {
        return type;
    }

    public void setType(BookableItemType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public List<PaymentOption> getPaymentOptions() {
        return paymentOptions;
    }

    public void setPaymentOptions(List<PaymentOption> paymentOptions) {
        this.paymentOptions = paymentOptions;
    }

    public void addPaymentOption(PaymentOption paymentOption){
        this.paymentOptions.add(paymentOption);
    }
}
