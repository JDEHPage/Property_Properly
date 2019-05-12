package com.propertyproperly.codeclan.PropertyProperlyService.repositories.Customer;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Booking;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class CustomerImpl implements CustomerRepositoryCustom {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Booking> getBookingsNotInPast() {
        List<Booking> result = null;
        LocalDate today = LocalDate.now();

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Booking.class);
            criteria.createAlias("bookings", "bookingAlias");

            criteria.add(Restrictions.ge("bookingAlias.endDate", today)); //endDate stored as String in db but converted into Date when fetched.

            result = criteria.list();

        } catch ( HibernateException ex ) {
            ex.printStackTrace();
        }

        return result;
    }
}
