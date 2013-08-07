package com.anyconsole.core.parser;

import com.anyconsole.core.command.CommandBuilder;
import com.anyconsole.core.parser.visitor.SQLStatementVisitor;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;

import java.io.StringReader;

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
    public void execute(CommandBuilder commandBuilder) {
        statement.accept(new SQLStatementVisitor(commandBuilder));
    }
}
