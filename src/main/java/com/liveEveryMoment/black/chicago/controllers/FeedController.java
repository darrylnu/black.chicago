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

        StringBuilder sb = new StringBuilder();
        for (EventModel event: eventModels) {
            sb.append("eventName: " + event.getEventName() + ", " +
                    "date: " + event.getDateTime().getDate() + ", " +
                    "startTime: " + event.getDateTime().getStartTime() + ", " +
                    "endTime: " + event.getDateTime().getEndTime() + ", " +
                    "venueName: " + event.getVenue().getName() + ", " +
                    "streetAddress: " + event.getVenue().getStreetAddress() + ", " +
                    "city: " + event.getVenue().getCity() + ", " +
                    "state: " + event.getVenue().getState() + ", " +
                    "zipCode: " + event.getVenue().getZipCode() + ", " +
                    "eventImgUrl: " + event.getEventImgUrl() + ", " +
                    "reservationLink: " + event.getReservationLink() +
                    "description:" + event.getDescription() +
                    "---------------------------------------------------- \br \n \r");
        }
        return sb.toString();

    }
}
