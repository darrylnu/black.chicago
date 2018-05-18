package com.liveEveryMoment.black.chicago.mappers;

import com.liveEveryMoment.black.chicago.models.EventModel;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeedResponseMapper {

    public List<EventModel> mapEvents(List<Document> eventsResponseType) {
        List<EventModel> eventModels = new ArrayList<>();
        for (Document event: eventsResponseType) {
            EventModel eventModel = new EventModel((String) event.get("eventName"), (String) event.get("date"), (Integer) event.get("startTime"), (String) event.get("location"), (String) event.get("eventImgUrl"), (String) event.get("reservationLink"));
            eventModels.add(eventModel);
        }
        return eventModels;
    }
}
