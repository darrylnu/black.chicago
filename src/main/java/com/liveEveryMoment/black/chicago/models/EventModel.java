package com.liveEveryMoment.black.chicago.models;

public class EventModel {

    private final String eventName;
    private final DateTime dateTime;
    private final Venue venue;
    private final String eventImgUrl;
    private final String reservationLink;
    private final String description;

    public EventModel(String eventName, DateTime dateTime, Venue venue, String eventImgUrl, String reservationLink, String description) {
        this.eventName = eventName;
        this.dateTime = dateTime;
        this.venue = venue;
        this.eventImgUrl = eventImgUrl;
        this.reservationLink = reservationLink;
        this.description = description;
    }

    public String getEventName() {
        return eventName;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public Venue getVenue() {
        return venue;
    }

    public String getEventImgUrl() {
        return eventImgUrl;
    }

    public String getReservationLink() {
        return reservationLink;
    }

    public String getDescription() {
        return description;
    }
}
