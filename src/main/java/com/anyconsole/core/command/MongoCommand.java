package com.anyconsole.core.command;

import com.anyconsole.core.client.MongoClient;

/**
 * User: kbabushkin
 * Date: 8/7/13
 */

public class MongoCommand implements Command {

    private MongoClient mongoClient = new MongoClient();

    @Override
    public Result execute() {
        //TODO: implement command execution
        return new MongoResult();
    }
}
