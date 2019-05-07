package com.propertyproperly.codeclan.PropertyProperlyService.controllers;


import com.propertyproperly.codeclan.PropertyProperlyService.repositories.Amenities.AmenityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/amenities")
public class AmenityController {

    @Autowired
    AmenityRepository amenityRepository;
}
