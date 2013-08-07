package com.anyconsole.core.command;

import com.anyconsole.core.client.MongoClient;

/**
 * User: kbabushkin
 * Date: 8/7/13
 */

public abstract class MongoCommand implements Command {

    protected MongoClient mongoClient = new MongoClient();
    
    protected String collection;

    public MongoCommand withCollection(String collection) {
        this.collection = collection;
        return this;
    }
}
