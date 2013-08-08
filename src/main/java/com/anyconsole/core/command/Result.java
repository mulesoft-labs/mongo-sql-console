package com.anyconsole.core.command;

/**
 * User: kbabushkin
 * Date: 8/7/13
 */

public interface Result {
    <T extends Object> T getResult();
}
