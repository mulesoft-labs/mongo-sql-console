package com.anyconsole.core.command;

/**
 * User: kbabushkin
 * Date: 8/7/13
 */

public class MongoResult<T> implements Result {
    
    private final T result;
    
    public MongoResult(T result) {
        this.result = result;
    }

    @Override
    public T getResult() {
        return result;
    }
}
