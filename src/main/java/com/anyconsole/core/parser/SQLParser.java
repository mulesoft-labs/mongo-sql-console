package com.anyconsole.core.parser;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;

import java.io.StringReader;

import com.anyconsole.db.Builder;

/**
 * User: kbabushkin
 * Date: 8/6/13
 */

public class SQLParser implements Parser {

    private CCJSqlParserManager parserManager = new CCJSqlParserManager();
    private Statement statement;

    public SQLParser(String expression) throws JSQLParserException {
        statement = parserManager.parse(new StringReader(expression));
    }

    @Override
    public String execute(Builder builder) {
        SQLVisitor sqlVisitor = new SQLVisitor(builder);
        statement.accept(sqlVisitor);
        return sqlVisitor.getResult();
    }
}
