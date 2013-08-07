package com.anyconsole.core.client;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;

import java.net.UnknownHostException;
import java.util.Set;

/**
 * User: kbabushkin
 * Date: 8/7/13
 */

public class MongoClient {
    private static String DEFAULT_DB_NAME = "hackathon";
    private Mongo mongoClient;


    // let's assume for now that db is localhost and has no credentials. MS.
    public DB getDatastore() {
        return getClient().getDB(DEFAULT_DB_NAME);
    }

    public DB getDatastore(String dbName) {
        return getClient().getDB(dbName);
    }

    public String executeSelect(DB db) {
        StringBuilder result = new StringBuilder();
        DBCollection coll = db.getCollection("testCollection");
        DBCursor cursor = coll.find(new BasicDBObject("i", new BasicDBObject("$gt", 50)));
        try {
            while(cursor.hasNext()) {
                result.append(cursor.next().toString());
            }
        } finally {
            cursor.close();
        }

        return result.toString();
    }

    public String executeInsert(DB db) {
        DBCollection coll = db.getCollection("testCollection");
        BasicDBObject doc = new BasicDBObject("name", "MongoDB").
                append("type", "database").
                append("count", 1).
                append("info", new BasicDBObject("x", 203).append("y", 102));

        coll.insert(doc);
        return doc.getObjectId("_id").toString();
    }

    public String executeUpdate(DB db) {
        DBCollection coll = db.getCollection("testCollection");
        BasicDBObject doc = new BasicDBObject("name", "MongoDB").
                append("type", "database").
                append("count", 1).
                append("info", new BasicDBObject("x", 203).append("y", 102));

        WriteResult wr = coll.updateMulti(new BasicDBObject("i", new BasicDBObject("$gt", 50)), doc);
        return wr.toString();
    }

    private Set<String> showDatabases(DB db) {
        return db.getCollectionNames();
    }

    private Mongo getClient() {
        if (mongoClient == null) {
            try {
                mongoClient = new Mongo("localhost" , 27017 );
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            } catch (MongoException e) {
                throw new RuntimeException(e);
            }
        }
        return mongoClient;
    }
}
