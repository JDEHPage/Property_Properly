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
		BookableItemType singleRoom = new BookableItemType("Single Room");
		BookableItem room101 = new BookableItem( singleRoom, 1, 50);
	}

	@Test
	public void canCreateProperty(){
		BookableItemType singleRoom = new BookableItemType("Single Room");
		BookableItem room101 = new BookableItem( singleRoom, 1, 50);

		Property guestHouse = new Property("Suppa Duppa Guest House");
		guestHouse.addBookableItem(room101);

		assertEquals(1, guestHouse.getBookableItems().size());
		assertEquals(guestHouse, room101.getProperty());
	}

	@Test
	public void canAddPaymentOptionToBookableItem(){
		PaymentOption creditCard = new PaymentOption( "credit card");
		Amenity ensuiteBathroom = new Amenity("Ensuite Bathroom");

		BookableItemType singleRoom = new BookableItemType("Single Room");
		BookableItem room101 = new BookableItem( singleRoom, 1, 50);

		room101.addPaymentOption(creditCard);
		room101.addAmenity(ensuiteBathroom);

		assertEquals(1, room101.getPaymentOptions().size());
		assertEquals(1, room101.getAmenities().size());
	}

	@Test
	public void canAddANewCustomer(){
		Customer customer1 = new Customer("Joe Bloggs", "Glasgow", "jblogs@gmail.com");
	}

	@Test
	public void canCreateCustomerBooking() {
		BookableItemType singleRoom = new BookableItemType("Single Room");
		BookableItem room101 = new BookableItem( singleRoom, 1, 50);
		Customer customer1 = new Customer("Joe Bloggs", "Glasgow", "jblogs@gmail.com");


		CustomerBooking booking1 = new CustomerBooking("2019-05-01", "2019-05-04", customer1);
		booking1.addBookableItem(room101);
		customer1.addBooking(booking1);
		assertEquals(1, customer1.getBookings().size());
	}

	@Test
	public void canCreateMaintenanceBooking(){
		BookableItemType singleRoom = new BookableItemType("Single Room");
		BookableItem room101 = new BookableItem( singleRoom, 1, 50);

		MaintenanceBooking booking2 = new MaintenanceBooking("2019-05-01", "2019-05-04", "painting");
		booking2.addBookableItem(room101);
		room101.addBooking(booking2);
		assertEquals(1, room101.getBookings().size());
	}

}
