package com.liveEveryMoment.black.chicago.services;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class FeedDbService {

    private static final String DB_USER = "put user here";
    private static final String DB_PASSWORD = "put password here";
    private static final String DB_HOST = "put host here";
    private static final String DB_NAME = "put dbname here";

    public FeedDbService() {}

    public FeedResponseType retrieveFeed() {

        StringBuilder uriStringBuilder = new StringBuilder();
        uriStringBuilder.append("mongodb://")
                .append(DB_USER)
                .append(":")
                .append(DB_PASSWORD)
                .append("@")
                .append(DB_HOST)
                .append("/")
                .append(DB_NAME);
        MongoClientURI uri = new MongoClientURI(uriStringBuilder.toString());
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());


    }

}
