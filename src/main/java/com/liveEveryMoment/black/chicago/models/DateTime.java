package com.liveEveryMoment.black.chicago.models;

public class DateTime {

    private int date;
    private String dateString;
    private String startTime;
    private String endTime;

    public DateTime(int date, String startTime, String endTime) {
        this(date, null, startTime, endTime);
    }

    public DateTime(int date, String dateString, String startTime, String endTime) {
        this.date = date;
        this.dateString = dateString;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getDate() {
        return date;
    }

    public String getDateString() {
        return dateString;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
