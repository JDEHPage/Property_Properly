package com.propertyproperly.codeclan.PropertyProperlyService.Controllers;

import com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItems.BookableItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/items")
public class BookableItemController {

    @Autowired
    BookableItemRepository bookableItemRepository;


}
