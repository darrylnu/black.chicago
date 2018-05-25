package com.liveEveryMoment.black.chicago.controllers;

import com.liveEveryMoment.black.chicago.models.DateTime;
import com.liveEveryMoment.black.chicago.models.EventModel;
import com.liveEveryMoment.black.chicago.models.Venue;
import com.liveEveryMoment.black.chicago.services.FeedDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path="/create")
public class CreateEventController {


    @Autowired
    private FeedDbService feedDbService;

    public CreateEventController(FeedDbService feedDbService) {
        this.feedDbService = feedDbService;
    }

    @RequestMapping("/form")
    public ModelAndView getCreationForm() {
        //links to form view
        return new ModelAndView();
    }

    @RequestMapping(value = "/submitForm", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView submitEventCreationForm(HttpServletRequest request,
                                                @RequestParam(value = "eventName") String eventName,
                                                @RequestParam(value = "venue") String venueName,
                                                @RequestParam(value = "streetAddress") String streetAddress,
                                                @RequestParam(value = "city") String city,
                                                @RequestParam(value = "state", required = false) String state,
                                                @RequestParam(value = "zipCode", required = false) int zipCode,
                                                @RequestParam(value = "date") int date,
                                                @RequestParam(value = "startTime") String startTime,
                                                @RequestParam(value = "endTime", required = false) String endTime,
                                                @RequestParam(value = "imageUrl") String eventImgUrl,
                                                @RequestParam(value = "reservationLink") String reservationLink,
                                                @RequestParam(value = "description", required = false) String description) {
        Venue venue = new Venue(venueName, city, state, streetAddress, zipCode);
        DateTime dateTime = new DateTime(date, startTime, endTime);
        feedDbService.postEvent(new EventModel(eventName, dateTime, venue, eventImgUrl, reservationLink, description));
        return new ModelAndView("redirect:/feed");
    }
}
