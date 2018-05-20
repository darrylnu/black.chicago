package com.liveEveryMoment.black.chicago.models;

public class Venue {

    private String name;
    private String city;
    private String state;
    private String streetAddress;
    private int zipCode;

    public Venue(String name, String city, String state, String streetAddress, int zipCode) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public int getZipCode() {
        return zipCode;
    }
}
