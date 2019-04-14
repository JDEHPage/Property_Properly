package com.propertyproperly.codeclan.PropertyProperlyService;

import com.propertyproperly.codeclan.PropertyProperlyService.models.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}
