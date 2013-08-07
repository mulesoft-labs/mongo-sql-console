package com.anyconsole.core.parser;

import net.sf.jsqlparser.util.TablesNamesFinder;

/**
 * User: kbabushkin
 * Date: 8/6/13
 */

public class SQLVisitor extends TablesNamesFinder {
    private String mongoExpression;

    //TODO: add visitors to construct mongo expression

    public String getMongoExpression() {
        return mongoExpression;
    }
}
