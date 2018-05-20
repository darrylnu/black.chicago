package com.liveEveryMoment.black.chicago.mappers;

import com.liveEveryMoment.black.chicago.models.DateTime;
import com.liveEveryMoment.black.chicago.models.EventModel;
import com.liveEveryMoment.black.chicago.models.Venue;
import org.bson.Document;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class FeedResponseMapper {
    private static final Logger LOGGER = Logger.getLogger(FeedResponseMapper.class.getName());

    public List<EventModel> mapEvents(List<Document> eventDocumentList) {
        List<EventModel> eventModels = new ArrayList<>();
        for (Document event: eventDocumentList) {
            String eventName = event.getString("eventName");
            DateTime dateTime = getDateTime(event);
            Venue venue = getVenue(event);
            String eventImgUrl =  event.getString("eventImgUrl");
            String reservationLink =  event.getString("reservationLink");
            if (!StringUtils.isEmpty(eventName) && dateTime != null
                    && venue != null && !StringUtils.isEmpty(eventImgUrl) && !StringUtils.isEmpty(reservationLink)) {
                EventModel eventModel = new EventModel(eventName, dateTime , venue, eventImgUrl, reservationLink);
                eventModels.add(eventModel);
            } else {
                LOGGER.warning(String.format("Null event field found: %s, %s, %s, %s, %s", eventName, dateTime, venue, eventImgUrl, reservationLink));
            }
        }
        return eventModels;
    }

    private DateTime getDateTime(Document event) {
        Document dateTime = (Document) event.get("dateTime");
        int date = dateTime.getInteger("date", -1);
        String startTime = dateTime.getString("startTime");
        String endTime = dateTime.getString("endTime");
        if (date != -1 && !StringUtils.isEmpty(startTime)) {
            return new DateTime(date, startTime, endTime);
        }
        return null;
    }

    private Venue getVenue(Document event) {
        Document venue = (Document) event.get("venue");
        String venueName = venue.getString("name");
        String city = venue.getString("city");
        String state = venue.getString("state");
        String streetAddress = venue.getString("streetAddress");
        int zipCode = venue.getInteger("zipCode", -1);
        if (!StringUtils.isEmpty(venueName) && !StringUtils.isEmpty(city) && !StringUtils.isEmpty(state) && !StringUtils.isEmpty(streetAddress)
                && zipCode != -1) {
            return new Venue(venueName, city, state, streetAddress, zipCode);
        }
        return null;
    }
}
