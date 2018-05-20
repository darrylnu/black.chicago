package com.liveEveryMoment.black.chicago.models;

public class DateTime {

    private int date;
    private String startTime;
    private String endTime;

    public DateTime(int date, String startTime, String endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
