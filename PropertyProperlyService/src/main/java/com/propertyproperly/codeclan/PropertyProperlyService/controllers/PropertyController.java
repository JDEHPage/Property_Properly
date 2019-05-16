package com.propertyproperly.codeclan.PropertyProperlyService.controllers;

import com.propertyproperly.codeclan.PropertyProperlyService.repositories.Property.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/properties")
public class PropertyController {

    @Autowired
    PropertyRepository propertyRepository;
}
