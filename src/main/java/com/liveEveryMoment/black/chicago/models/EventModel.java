package com.liveEveryMoment.black.chicago.models;

public class EventModel {

    private final String eventName;
    private final String date;
    private final Integer startTime;
    private final String location;
    private final String eventImgUrl;
    private final String reservationLink;

    public EventModel(String eventName, String date, Integer startTime, String location, String eventImgUrl, String reservationLink) {
        this.eventName = eventName;
        this.date = date;
        this.startTime = startTime;
        this.location = location;
        this.eventImgUrl = eventImgUrl;
        this.reservationLink = reservationLink;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDate() {
        return date;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public String getLocation() {
        return location;
    }

    public String getEventImgUrl() {
        return eventImgUrl;
    }

    public String getReservationLink() {
        return reservationLink;
    }
}
