package com.liveEveryMoment.black.chicago.services;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeedDbService {

    @Autowired
    private Environment environment;

    public FeedDbService() {}

    public List<Document> retrieveFeed () {
        String mongoClientUriStr = environment.getProperty("mongodb.client.uri");
        MongoClientURI uri = new MongoClientURI(mongoClientUriStr);
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        MongoCollection<Document> eventsTable = db.getCollection("UrbanEvents");
        List<Document> events = new ArrayList<>();
        MongoCursor<Document> cursor = eventsTable.find().iterator();
        try {
            while(cursor.hasNext()) {
                events.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return events;
    }

}
