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

        List<Document> eventsReponse = feedDbService.retrieveFeed();
        List<EventModel> eventModels = feedResponseMapper.mapEvents(eventsReponse);
        return "eventName: " + eventModels.get(0).getEventName() + ", " +
                "date: " + eventModels.get(0).getDate() + ", " +
                "startTime: " + eventModels.get(0).getStartTime() + ", " +
                "location: " + eventModels.get(0).getLocation() + ", " +
                "eventImgUrl: " + eventModels.get(0).getEventImgUrl() + ", " +
                "reservationLink: " + eventModels.get(0).getReservationLink();
    }
}
