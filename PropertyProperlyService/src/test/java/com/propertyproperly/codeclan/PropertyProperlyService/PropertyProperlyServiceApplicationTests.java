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

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = format.format( new Date()   );
		Date startDate = null;
		try {
			startDate = format.parse("2019-05-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date endDate = null;
		try {
			endDate = format.parse("2019-05-04");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		CustomerBooking booking1 = new CustomerBooking(startDate, endDate, room101, customer1);
		assertEquals(1, customer1.getBookings().size());
	}

	@Test
	public void canCreateMaintenanceBooking(){

	}

}
