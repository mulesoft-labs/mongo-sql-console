package com.anyconsole.core.parser;

import com.anyconsole.core.command.MongoCommandBuilder;
import com.anyconsole.core.command.Result;
import net.sf.jsqlparser.JSQLParserException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * User: kbabushkin
 * Date: 8/6/13
 */

public class SQLParserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void parseSelectTest() throws JSQLParserException {
        SQLParser parser = new SQLParser("SELECT * FROM table1");
    }

    @Test
    public void parseUpdateTest() throws JSQLParserException {
        SQLParser parser = new SQLParser("UPDATE table1 SET table1.column=value1");
        MongoCommandBuilder commandBuilder = new MongoCommandBuilder();
        parser.execute(commandBuilder);

        Result result = commandBuilder.getCommand().execute();
        System.out.println(result.getStringResult());
    }
    
    @Test
    public void parseUpdateWhereTest() throws JSQLParserException {
        SQLParser parser = new SQLParser("UPDATE table1 SET column1='value1' where column2 = 'value2'");
        MongoCommandBuilder commandBuilder = new MongoCommandBuilder();
        parser.execute(commandBuilder);

        Result result = commandBuilder.getCommand().execute();
        System.out.println(result.getStringResult());
    }
}
