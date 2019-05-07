//See http://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#basic-jpa-convert
package com.propertyproperly.codeclan.PropertyProperlyService.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Converter
public class EndDateStringConverter implements AttributeConverter<Date, String> {
    @Override
    public String convertToDatabaseColumn(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    @Override
    public Date convertToEntityAttribute(String dbData) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date result = null;

        try {
            result = dateFormat.parse(dbData);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }
}
