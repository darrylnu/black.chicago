package com.liveEveryMoment.black.chicago.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Logger;

public class DateTimeFormatter {
    private static final Logger LOGGER = Logger.getLogger(DateTimeFormatter.class.getName());

    public static int formatDateForDb(String date) {
        Date dateFromString;
        try {
            dateFromString = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            LOGGER.warning("Error parsing date: " + e.getMessage());
            return -1;
        }
        String dateStr = Integer.toString(dateFromString.getMonth() + 1) + Integer.toString(dateFromString.getDay()) + Integer.toString(dateFromString.getYear());
        int formattedDateInt = Integer.parseInt(dateStr);
        return formattedDateInt;
    }

    public static String getFormattedTime(String time) {
        if (!StringUtils.isEmpty(time)) {
        LocalTime timeFromString = LocalTime.parse(time);
        String localTimeString = java.time.format.DateTimeFormatter.ofPattern("hh:mm a").format(timeFromString);
        return localTimeString;
        }
        return "";
    }
}
