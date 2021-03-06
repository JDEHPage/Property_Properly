package com.propertyproperly.codeclan.PropertyProperlyService.Controllers;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItemType;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItemType.BookableItemTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/types")
public class BookableItemTypeController {

    @Autowired
    BookableItemTypeRepository bookableItemTypeRepository;

    @GetMapping(value = "/")
    public List<BookableItemType> getAllTypes(){
        return bookableItemTypeRepository.findAll();
    }



}
