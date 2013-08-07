package com.anyconsole.core.parser;

import com.anyconsole.core.builder.Builder;

/**
 * User: kbabushkin
 * Date: 8/6/13
 */

public interface Parser {
    String execute(Builder builder) throws Exception;
}
