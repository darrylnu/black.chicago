package com.liveEveryMoment.black.chicago.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FeedController {

    @ResponseBody
    @RequestMapping("/feed")
    public String getFeed() {
        //call service that connects to the database and fetch the feed info
        //return the feed info
        return "this is the feed page";
    }
}
