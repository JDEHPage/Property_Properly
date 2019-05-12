//See http://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#basic-jpa-convert
package com.propertyproperly.codeclan.PropertyProperlyService.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.util.Date;
//import java.util.Locale;

@Converter
public class DateStringConverter implements AttributeConverter<LocalDate, String> {
    @Override
    public String convertToDatabaseColumn(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", new Locale("en", "UK"));
//        return dateFormat.format(date);
    }

    @Override
    public LocalDate convertToEntityAttribute(String dbData) {
        return LocalDate.parse(dbData);
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", new Locale("en", "UK"));
//        Date result = null;
//
//        try {
//            result = dateFormat.parse(dbData);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        return result;
    }
}
