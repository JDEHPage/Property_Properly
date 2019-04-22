package com.propertyproperly.codeclan.PropertyProperlyService;

import com.propertyproperly.codeclan.PropertyProperlyService.models.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertyProperlyServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreatePaymentOption(){
		PaymentOption creditCard = new PaymentOption( "credit card");
	}

	@Test
	public void canCreateBookableItemType(){
		BookableItemType singleRoom = new BookableItemType("Single Room");
	}

	@Test
	public void canCreateAmenity(){
		Amenity ensuiteBathroom = new Amenity("Ensuite Bathroom");
	}

	@Test
	public void canCreateBookableItem(){
		Property guest_house = new Property("Guest House");
		BookableItemType singleRoom = new BookableItemType("Single Room");
		BookableItem room101 = new BookableItem("Room 101", singleRoom, 1, 50, guest_house);
	}

	@Test
	public void canCreateProperty(){
		Property guest_house = new Property("Guest House");
		BookableItemType singleRoom = new BookableItemType("Single Room");
		BookableItem room101 = new BookableItem("Room 101", singleRoom, 1, 50, guest_house);

		Property guestHouse = new Property("Suppa Duppa Guest House");
		guestHouse.addBookableItem(room101);

		assertEquals(1, guestHouse.getBookableItems().size());
		assertNotNull(room101.getProperty());
	}

	@Test
	public void canAddPaymentOptionToBookableItem(){
		Property guest_house = new Property("Guest House");
		PaymentOption creditCard = new PaymentOption( "credit card");

		BookableItemType singleRoom = new BookableItemType("Single Room");
		BookableItem room101 = new BookableItem("Room 101", singleRoom, 1, 50, guest_house);

		room101.addPaymentOption(creditCard);

		assertEquals(1, room101.getPaymentOptions().size());
	}

	@Test
	public void canAddAmenityToBookableItem(){
		Property guest_house = new Property("Guest House");
		Amenity ensuiteBathroom = new Amenity("Ensuite Bathroom");

		BookableItemType singleRoom = new BookableItemType("Single Room");
		BookableItem room101 = new BookableItem("Room 101", singleRoom, 1, 50, guest_house);

		room101.addAmenity(ensuiteBathroom);

		assertEquals(1, room101.getAmenities().size());
	}

	@Test
	public void canAddANewCustomer(){
		Customer customer1 = new Customer("Joe Bloggs", "Glasgow", "jblogs@gmail.com");
	}

	@Test
	public void canCreateCustomerBooking() {
		Property guest_house = new Property("Guest House");
		BookableItemType singleRoom = new BookableItemType("Single Room");
		BookableItem room101 = new BookableItem("Room 101", singleRoom, 1, 50, guest_house);
		Customer customer1 = new Customer("Joe Bloggs", "Glasgow", "jblogs@gmail.com");


		CustomerBooking booking1 = new CustomerBooking("2019-05-01", "2019-05-04", customer1);
		booking1.addBookableItem(room101);
		customer1.addBooking(booking1);
		assertEquals(1, customer1.getBookings().size());
	}

	@Test
	public void canCreateMaintenanceBooking(){
		Property guest_house = new Property("Guest House");
		BookableItemType singleRoom = new BookableItemType("Single Room");
		BookableItem room101 = new BookableItem("Room 101", singleRoom, 1, 50, guest_house);

		MaintenanceBooking booking2 = new MaintenanceBooking("2019-05-01", "2019-05-04", "painting");
		booking2.addBookableItem(room101);
		room101.addBooking(booking2);
		assertEquals(1, room101.getBookings().size());
	}

}
