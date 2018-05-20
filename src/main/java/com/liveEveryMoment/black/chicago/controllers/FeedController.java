package com.liveEveryMoment.black.chicago.controllers;

import com.liveEveryMoment.black.chicago.mappers.FeedResponseMapper;
import com.liveEveryMoment.black.chicago.models.EventModel;
import com.liveEveryMoment.black.chicago.services.FeedDbService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FeedController {

    @Autowired
    private FeedDbService feedDbService;

    @Autowired
    private FeedResponseMapper feedResponseMapper;

    private FeedController(FeedDbService feedDbService, FeedResponseMapper feedResponseMapper) {
        this.feedDbService = feedDbService;
        this.feedResponseMapper = feedResponseMapper;
    }

    @ResponseBody
    @RequestMapping("/feed")
    public String getFeed() {
        //call service that connects to the database and fetch the feed info
        //return the feed info

        List<Document> eventsResponse = feedDbService.retrieveFeed();
        List<EventModel> eventModels = feedResponseMapper.mapEvents(eventsResponse);
        return "eventName: " + eventModels.get(0).getEventName() + ", " +
                "date: " + eventModels.get(0).getDateTime().getDate() + ", " +
                "startTime: " + eventModels.get(0).getDateTime().getStartTime() + ", " +
                "endTime: " + eventModels.get(0).getDateTime().getEndTime() + ", " +
                "venueName: " + eventModels.get(0).getVenue().getName() + ", " +
                "streetAddress: " + eventModels.get(0).getVenue().getStreetAddress() + ", " +
                "city: " + eventModels.get(0).getVenue().getCity() + ", " +
                "state: " + eventModels.get(0).getVenue().getState() + ", " +
                "zipCode: " + eventModels.get(0).getVenue().getZipCode() + ", " +
                "eventImgUrl: " + eventModels.get(0).getEventImgUrl() + ", " +
                "reservationLink: " + eventModels.get(0).getReservationLink() +
                "----------------------------------------------------" +
                "eventName: " + eventModels.get(1).getEventName() + ", " +
                "date: " + eventModels.get(1).getDateTime().getDate() + ", " +
                "startTime: " + eventModels.get(1).getDateTime().getStartTime() + ", " +
                "endTime: " + eventModels.get(1).getDateTime().getEndTime() + ", " +
                "venueName: " + eventModels.get(1).getVenue().getName() + ", " +
                "streetAddress: " + eventModels.get(1).getVenue().getStreetAddress() + ", " +
                "city: " + eventModels.get(1).getVenue().getCity() + ", " +
                "state: " + eventModels.get(1).getVenue().getState() + ", " +
                "zipCode: " + eventModels.get(1).getVenue().getZipCode() + ", " +
                "eventImgUrl: " + eventModels.get(1).getEventImgUrl() + ", " +
                "reservationLink: " + eventModels.get(1).getReservationLink() +
                "----------------------------------------------------" +
                "eventName: " + eventModels.get(2).getEventName() + ", " +
                "date: " + eventModels.get(2).getDateTime().getDate() + ", " +
                "startTime: " + eventModels.get(2).getDateTime().getStartTime() + ", " +
                "endTime: " + eventModels.get(2).getDateTime().getEndTime() + ", " +
                "venueName: " + eventModels.get(2).getVenue().getName() + ", " +
                "streetAddress: " + eventModels.get(2).getVenue().getStreetAddress() + ", " +
                "city: " + eventModels.get(2).getVenue().getCity() + ", " +
                "state: " + eventModels.get(2).getVenue().getState() + ", " +
                "zipCode: " + eventModels.get(2).getVenue().getZipCode() + ", " +
                "eventImgUrl: " + eventModels.get(2).getEventImgUrl() + ", " +
                "reservationLink: " + eventModels.get(2).getReservationLink();

    }
}
