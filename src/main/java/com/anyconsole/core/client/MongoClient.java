package com.anyconsole.core.client;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

import java.net.UnknownHostException;

/**
 * User: kbabushkin
 * Date: 8/7/13
 */

public class MongoClient {
    private static String DEFAULT_DB_NAME = "hackathon";
    private static Mongo mongoClient;


    // let's assume for now that db is localhost and has no credentials. MS.
    public DB getDatastore() {
        return getClient().getDB(DEFAULT_DB_NAME);
    }

    public DB getDatastore(String dbName) {
        return getClient().getDB(dbName);
    }

    private Mongo getClient() {
        if (mongoClient == null) {
            try {
                mongoClient = new Mongo("127.0.0.1" , 27017 );
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            } catch (MongoException e) {
                throw new RuntimeException(e);
            }
        }
        return mongoClient;
    }
}
