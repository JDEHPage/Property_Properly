package com.propertyproperly.codeclan.PropertyProperlyService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "amenities")
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

//    @JsonIgnoreProperties("amenities")
//    @ManyToMany
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinTable(
//            joinColumns = {@JoinColumn(name = "amenity_id", nullable = false, updatable = false)},
//            inverseJoinColumns = {@JoinColumn(name = "bookableitem_id", nullable = false, updatable = false)}
//    )
//    List<BookableItem> bookableItems;

    public Amenity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Amenity() {
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

//    public List<BookableItem> getBookableItems() {
//        return bookableItems;
//    }
//
//    public void setBookableItems(List<BookableItem> bookableItems) {
//        this.bookableItems = bookableItems;
//    }
}
