package com.liveEveryMoment.black.chicago.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Widget {

    @RequestMapping("/hello")
    @ResponseBody
    public String getHello() {
        return "hi there";
    }
}
