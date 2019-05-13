//package com.propertyproperly.codeclan.PropertyProperlyService.projections;
//
//import com.propertyproperly.codeclan.PropertyProperlyService.models.BookableItem;
//import com.propertyproperly.codeclan.PropertyProperlyService.models.Booking;
//import com.propertyproperly.codeclan.PropertyProperlyService.models.CustomerBooking;
//import org.springframework.data.rest.core.config.Projection;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Projection(name = "embedBooking", types = Booking.class)
//public interface EmbedBooking {
//    Long getId();
//    String getStartDate();
//    LocalDate getEndDate();
//    String getNotes();
//    List<BookableItem> getBookableItems();
//}
