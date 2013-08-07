package com.anyconsole.core.command;

/**
 * User: kbabushkin
 * Date: 8/7/13
 */
public class MongoResult implements Result {
    
    private final String result;
    
    public MongoResult(String result) {
        this.result = result;
    }

    @Override
    public String getStringResult() {
        return result;
    }
}
