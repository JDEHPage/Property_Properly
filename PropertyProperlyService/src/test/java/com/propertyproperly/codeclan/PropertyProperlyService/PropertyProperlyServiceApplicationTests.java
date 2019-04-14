package com.propertyproperly.codeclan.PropertyProperlyService;

import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItemType;
import com.propertyproperly.codeclan.PropertyProperlyService.models.PaymentOption;
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
	public void canCreateBookableItem(){
		BookableItemType singleRoom = new BookableItemType("Single Room");
		BookableItem room101 = new BookableItem( singleRoom, 1, 50);
	}

	@Test
	public void canAddPaymentOptionToBookableItem(){
		PaymentOption creditCard = new PaymentOption( "credit card");

		BookableItemType singleRoom = new BookableItemType("Single Room");
		BookableItem room101 = new BookableItem( singleRoom, 1, 50);

		room101.addPaymentOption(creditCard);

//		assertEquals(1, room101.getPaymentOptions().size());
	}

}
