package com.liveEveryMoment.black.chicago.controllers;

import com.liveEveryMoment.black.chicago.models.DateTime;
import com.liveEveryMoment.black.chicago.models.EventModel;
import com.liveEveryMoment.black.chicago.models.Venue;
import com.liveEveryMoment.black.chicago.services.FeedDbService;
import com.liveEveryMoment.black.chicago.utils.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/createEvent")
public class CreateEventServlet extends HttpServlet {

    @Autowired
    private FeedDbService feedDbService;

    public CreateEventServlet(FeedDbService feedDbService) {
        this.feedDbService = feedDbService;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventName = request.getParameter("eventName");
        String venueName = request.getParameter("venueName");
        String streetAddress = request.getParameter("streetAddress");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        int zipCode = Integer.parseInt(request.getParameter("zipCode"));
        String date = request.getParameter("date");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String eventImgUrl = request.getParameter("eventImgUrl");
        String reservationLink = request.getParameter("reservationLink");
        String description = request.getParameter("description");

        Venue venue = new Venue(venueName, city, state, streetAddress, zipCode);
        DateTime dateTime = new DateTime(DateTimeFormatter.formatDateForDb(date), DateTimeFormatter.getFormattedTime(startTime), DateTimeFormatter.getFormattedTime(endTime));
        feedDbService.postEvent(new EventModel(eventName, dateTime, venue, eventImgUrl, reservationLink, description), response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/form.jsp").forward(request, response);
    }
}
