package com.propertyproperly.codeclan.PropertyProperlyService;

import com.propertyproperly.codeclan.PropertyProperlyService.Repositories.Amenity.AmenityRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.Repositories.BookableItem.RoomRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.Repositories.BookableItemType.TypeRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.Repositories.MaintenanceBooking.MaintenancebRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.Repositories.PaymentOption.PaymentOptionRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.Repositories.Property.PropertyRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.models.*;
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
	TypeRepository typeRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	MaintenancebRepository maintenancebRepository;

	@Autowired
	PaymentOptionRepository paymentOptionRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateAmenity() {
		Amenity amenity = new Amenity("Bathroom", "Is Bathroom");
		amenityRepository.save(amenity);
	}

	@Test
	public void canCreatePayment() {
		PaymentOption paymentOption = new PaymentOption("Card");
		paymentOptionRepository.save(paymentOption);
	}

	@Test
	public void canCreateProperty() {
		Property property = new Property("Castle");
		propertyRepository.save(property);
	}

	@Test
	public void canCreateBookingItemType() {
		Property property = new Property("Cottange");
		propertyRepository.save(property);
		Type bookingItemType = new Type("Double", property);
		typeRepository.save(bookingItemType);
	}

	@Test
	public void canCreateBookableItem() {
		Property property = new Property("Place");
		propertyRepository.save(property);
		Type type = new Type("Single Room", property);
		typeRepository.save(type);
		Room room = new Room("R1", 1, 5000, type);
		roomRepository.save(room);
	}

	@Test
	public void canCreateMaintance() {
		Property property = new Property("Big Place");
		propertyRepository.save(property);
		Type type = new Type("Deluxue", property);
		typeRepository.save(type);
		property.addType(type);
		propertyRepository.save(property);

		Room room = new Room("R2", 5, 50000, type);
		roomRepository.save(room);

		PaymentOption paymentOption = new PaymentOption("Cash");
		paymentOptionRepository.save(paymentOption);

		Amenity amenity = new Amenity("Big Bathroom", "Is Bathroom");
		amenityRepository.save(amenity);

		room.addPaymentOption(paymentOption);
		roomRepository.save(room);

		room.addAmenity(amenity);
		roomRepository.save(room);


		Maintenanceb maintenanceb = new Maintenanceb("02/02/2018", "05/02/2018", "Painting");
		maintenancebRepository.save(maintenanceb);
		maintenanceb.addRoom(room);
		maintenancebRepository.save(maintenanceb);

		room.addBooking(maintenanceb);
		roomRepository.save(room);

	}
}
