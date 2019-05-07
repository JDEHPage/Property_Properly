package com.propertyproperly.codeclan.PropertyProperlyService.controllers;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItems.BookableItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/items")
public class BookableItemController {

    @Autowired
    BookableItemRepository bookableItemRepository;

}
