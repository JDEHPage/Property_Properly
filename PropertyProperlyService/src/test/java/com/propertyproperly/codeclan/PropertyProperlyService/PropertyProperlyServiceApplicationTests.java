package com.propertyproperly.codeclan.PropertyProperlyService;

import com.propertyproperly.codeclan.PropertyProperlyService.Repositories.Amenity.AmenityRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.Repositories.BookableItem.BookableItemRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.Repositories.BookableItemType.BookableItemTypeRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.Repositories.Property.PropertyRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.models.Amenity;
import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import com.propertyproperly.codeclan.PropertyProperlyService.models.BookingItemType;
import com.propertyproperly.codeclan.PropertyProperlyService.models.Property;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertyProperlyServiceApplicationTests {

	@Autowired
	AmenityRepository amenityRepository;

	@Autowired
	PropertyRepository propertyRepository;

	@Autowired
	BookableItemTypeRepository bookableItemTypeRepository;

	@Autowired
	BookableItemRepository bookableItemRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateAmenity() {
		Amenity amenity = new Amenity("Bathroom", "Is Bathroom");
		amenityRepository.save(amenity);
	}

	@Test
	public void canCreateProperty() {
		Property property = new Property("Place");
		propertyRepository.save(property);
	}

	@Test
	public void canCreateBookingItemType() {
		Property property = new Property("Place");
		propertyRepository.save(property);
		BookingItemType bookingItemType = new BookingItemType("Single Room", property);
		bookableItemTypeRepository.save(bookingItemType);
	}

	@Test
	public void canCreateBookableItem() {
		Property property = new Property("Place");
		propertyRepository.save(property);
		BookingItemType bookingItemType = new BookingItemType("Single Room", property);
		bookableItemTypeRepository.save(bookingItemType);
		BookableItem bookableItem = new BookableItem("R1", 1, 5000, bookingItemType, true);
		bookableItemRepository.save(bookableItem);
	}
}
