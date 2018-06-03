package com.liveEveryMoment.black.chicago.services;

import com.google.gson.Gson;
import com.liveEveryMoment.black.chicago.models.EventModel;
import com.liveEveryMoment.black.chicago.utils.DateTimeFormatter;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.apache.catalina.connector.Response;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gte;

@Component
public class FeedDbService {
    private static final Logger LOGGER = Logger.getLogger(FeedDbService.class.getName());

    @Autowired
    private Environment environment;

    private final MongoCollection<Document> eventsTable;

    public FeedDbService(Environment environment) {
        String mongoClientUriStr = environment.getProperty("mongodb.client.uri");
        MongoClientURI uri = new MongoClientURI(mongoClientUriStr);
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        eventsTable = db.getCollection("UrbanEvents");
    }

    public List<Document> retrieveFeed () {
        List<Document> events = new ArrayList<>();
        MongoCursor<Document> cursor = eventsTable.find(
                and(gte("dateTime.date", DateTimeFormatter.formatDateForDb(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now())))))
                .sort(Sorts.ascending("dateTime.date"))
                .iterator();
        try {
            while (cursor.hasNext()) {
                events.add(cursor.next());
            }
        } catch (Exception e) {
            LOGGER.warning("ERROR: Retrieving events from database failed: " + e.getMessage());
        } finally {
            cursor.close();
        }
        return events;
    }

    public void postEvent(EventModel eventModel, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        String eventJson = gson.toJson(eventModel);
        Document newEvent = Document.parse(eventJson);
        try {
            eventsTable.insertOne(newEvent);
            response.setStatus(Response.SC_ACCEPTED);
        } catch (Exception e) {
            LOGGER.warning("Something went wrong when trying to post event" + e.getMessage());
            response.setStatus(Response.SC_BAD_REQUEST);
            response.getWriter().write("Post unsuccessful: " + e.getMessage());
        }
    }
}
