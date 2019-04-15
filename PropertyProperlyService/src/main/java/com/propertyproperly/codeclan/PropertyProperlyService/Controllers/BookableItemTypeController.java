package com.propertyproperly.codeclan.PropertyProperlyService.Controllers;

import com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItemType.BookableItemTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bookable_item_types")
public class BookableItemTypeController {

    @Autowired
    BookableItemTypeRepository bookableItemTypeRepository;
}
