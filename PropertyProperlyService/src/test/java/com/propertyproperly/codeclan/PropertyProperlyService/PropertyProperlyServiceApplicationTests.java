package com.propertyproperly.codeclan.PropertyProperlyService;

import com.propertyproperly.codeclan.PropertyProperlyService.models.*;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItemType.BookableItemTypeRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItems.BookableItemRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.Booking.BookingRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.Customer.CustomerRepository;
import com.propertyproperly.codeclan.PropertyProperlyService.repositories.Property.PropertyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

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
//		propertyRepository.save(guest_house);

		BookableItemType singleRoom = new BookableItemType("Single Room");
//		bookableItemTypeRepository.save(singleRoom);

		BookableItem room101 = new BookableItem("Room 101", singleRoom, 1, 50, guest_house);
//		bookableItemRepository.save(room101);

		Customer customer1 = new Customer("Joe Bloggs", "Glasgow", "jblogs@gmail.com");
//		customerRepository.save(customer1);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		String dateString = format.format( new Date() );
		Date endDate = null;
		try {
			endDate = format.parse("2019-05-04");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		CustomerBooking booking = new CustomerBooking("2019-05-01", endDate, customer1);
		booking.addBookableItem(room101);
		customer1.addBooking(booking);
//		bookingRepository.save(booking);

		assertEquals(1, customer1.getBookings().size());
	}

	@Test
	public void canCreateMaintenanceBooking(){
		Property guest_house = new Property("Guest House");
//		propertyRepository.save(guest_house);
		BookableItemType singleRoom = new BookableItemType("Single Room");
//		bookableItemTypeRepository.save(singleRoom);
		BookableItem room101 = new BookableItem("Room 101", singleRoom, 1, 50, guest_house);
//		bookableItemRepository.save(room101);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		String dateString = format.format( new Date() );
		Date endDate = null;
		try {
			endDate = format.parse("2019-05-04");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		MaintenanceBooking booking2 = new MaintenanceBooking("2019-05-01", endDate, "painting");
		room101.addBooking(booking2);
//		booking2.addBookableItem(room101);
//		bookingRepository.save(booking2);

		assertEquals(1, room101.getBookings().size());
	}

	@Test
	public void bookableItemsStartsWithNoBookings(){
		Property guest_house = new Property("Guest House");
		propertyRepository.save(guest_house);
		BookableItemType singleRoom = new BookableItemType("Single Room");
		bookableItemTypeRepository.save(singleRoom);
		BookableItem room101 = new BookableItem("Room 101", singleRoom, 1, 50, guest_house);
		bookableItemRepository.save(room101);

		assertEquals(0, room101.getBookings().size());
	}

	@Test
	public void bookableItemCanGetBookings(){
		Property guest_house = new Property("Guest House");

		BookableItemType singleRoom = new BookableItemType("Single Room");

		BookableItem room101 = new BookableItem("Room 101", singleRoom, 1, 50, guest_house);

		Customer customer1 = new Customer("Joe Bloggs", "Glasgow", "jblogs@gmail.com");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		String dateString = format.format( new Date() );
		Date endDate = null;
		try {
			endDate = format.parse("2019-05-04");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		CustomerBooking booking = new CustomerBooking("2019-05-01", endDate, customer1);
		room101.addBooking(booking);

		assertEquals(1, room101.getBookings().size());
	}

	@Test
	public void bookableItemCanGetBookingsNotInPast(){
		Property guest_house = new Property("Guest House");
		BookableItemType singleRoom = new BookableItemType("Single Room");
		BookableItem room101 = new BookableItem("Room 101", singleRoom, 1, 50, guest_house);
		Customer customer1 = new Customer("Joe Bloggs", "Glasgow", "jblogs@gmail.com");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		String dateString = format.format( new Date() );
		Date endDate1 = null;
		Date endDate2 = null;
		try {
			endDate1 = format.parse("2019-05-04");
			endDate2 = format.parse("2020-05-04");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		CustomerBooking pastBooking = new CustomerBooking("2019-05-01", endDate1, customer1);
		CustomerBooking futureBooking = new CustomerBooking("2020-05-01", endDate2, customer1);

		pastBooking.addBookableItem(room101);
		room101.addBooking(pastBooking);
		futureBooking.addBookableItem(room101);
		room101.addBooking(futureBooking);

		assertEquals(1, room101.getBookingsNotInPast().size());
	}

}
