package com.propertyproperly.codeclan.PropertyProperlyService.Controllers;

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
@RequestMapping(value = "/bookableItems")
public class BookableItemController {

    @Autowired
    BookableItemRepository bookableItemRepository;

    @GetMapping( value = "/" )
    public List<BookableItem> getAllBookableItems(){ return bookableItemRepository.findAll(); }

    @GetMapping( value = "{id}" )
    public Optional<BookableItem> getSingleBookableItem(@PathVariable Long id){ return bookableItemRepository.findById(id); }

}
