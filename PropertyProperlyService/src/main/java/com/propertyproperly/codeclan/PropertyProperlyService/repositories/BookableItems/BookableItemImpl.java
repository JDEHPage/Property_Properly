package com.propertyproperly.codeclan.PropertyProperlyService.repositories.BookableItems;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Booking;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//public class BookableItemImpl {}

public class BookableItemImpl implements BookableItemRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Booking> getBookingsNotInPast() {
        List<Booking> result = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        Date endDateAsDate = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Booking.class);
            criteria.createAlias("bookings", "bookingAlias");

            criteria.add(Restrictions.ge("bookingAlias.endDate", today)); //endDate stored as String in db but converted into Date when fetched.

            result = criteria.list();
//            List<Booking> allBookings = bookings;
//
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date today = new Date();
//
//            // filter all bookings for those with an endDate < today
//            for( Booking booking:allBookings ){
//                Date endDateAsDate = null;
//                try {
//                    endDateAsDate = dateFormat.parse( booking.getEndDate() );
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//
//                if( endDateAsDate.compareTo( today ) >= 0 ){
//                    result.add(booking);
//                }
//            }

        } catch ( HibernateException ex ) {
            ex.printStackTrace();
        }

        return result;
    }
}
