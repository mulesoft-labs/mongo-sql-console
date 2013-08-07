package com.anyconsole.core.command;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public final class SelectMongoCommand extends MongoCommand {

    @Override
    public Result execute() {
        DBCollection mongoCollection = mongoClient.getDatastore().getCollection(collection);
        DBCursor cursor = mongoCollection.find();
        StringBuilder sb = new StringBuilder();
        try {
            while (cursor.hasNext()) {
                DBObject object = cursor.next();
                String json = JSON.serialize(object);
                sb.append(json);
                sb.append("\n");
            }
        } finally {
            cursor.close();
        }
        return new MongoResult(sb.toString());
    }

}
