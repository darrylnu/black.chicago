package com.liveEveryMoment.black.chicago.utils;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
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
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFromString);
        String dayOfMonth = cal.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + Integer.toString(cal.get(Calendar.DAY_OF_MONTH)) : Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String dateStr = Integer.toString(cal.get(Calendar.MONTH) + 1) + dayOfMonth + Integer.toString(cal.get(Calendar.YEAR));
        int formattedDateInt = Integer.parseInt(dateStr);
        return formattedDateInt;
    }

    public static String formatDateForModel(Integer date) {
        String dateStr = date.toString();
        if(dateStr.length() < 8) {
            dateStr = "0" + dateStr;
        }
        Date originalFormattedDate;
        try {
            originalFormattedDate = new SimpleDateFormat("MMddyyyy").parse(dateStr);
        } catch (ParseException e) {
            LOGGER.warning("Error parsing date: " + e.getMessage());
            return "";
        }
        SimpleDateFormat newFormatForDate = new SimpleDateFormat("MM-dd-yyyy");
        String formattedDate = newFormatForDate.format(originalFormattedDate);
        return formattedDate;

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
