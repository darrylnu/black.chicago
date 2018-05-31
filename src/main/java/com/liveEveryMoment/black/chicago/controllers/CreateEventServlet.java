package com.liveEveryMoment.black.chicago.controllers;

import com.liveEveryMoment.black.chicago.services.FeedDbService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CreateEventServlet")
public class CreateEventServlet extends HttpServlet {

    @Autowired
    private FeedDbService feedDbService;

    public CreateEventServlet(FeedDbService feedDbService) {
        this.feedDbService = feedDbService;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("inside post method");
    }
}
