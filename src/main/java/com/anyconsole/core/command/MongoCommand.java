package com.anyconsole.core.command;

/**
 * User: kbabushkin
 * Date: 8/7/13
 */

public abstract class MongoCommand implements Command {
    
    protected String collection;

    public MongoCommand withCollection(String collection) {
        this.collection = collection;
        return this;
    }
}
