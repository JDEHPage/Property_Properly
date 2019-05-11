//See http://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#basic-jpa-convert
package com.propertyproperly.codeclan.PropertyProperlyService.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Converter
public class DateStringConverter implements AttributeConverter<Date, String> {
    @Override
    public String convertToDatabaseColumn(Date date) {
        DateFormat s2dbDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String dateAsString = s2dbDateFormat.format(date);
        return dateAsString.substring(0,10);
    }

    @Override
    public Date convertToEntityAttribute(String dbData) {
        DateFormat db2sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date result = null;

        try {
            result = db2sDateFormat.parse(dbData);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }
}
