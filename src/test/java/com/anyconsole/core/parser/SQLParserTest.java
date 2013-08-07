package com.anyconsole.core.parser;

import com.anyconsole.db.Builder;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.update.Update;
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
        parser.execute(new Builder() {
            @Override
            public String getResult() {
                return null;  //Implementation goes here
            }

            @Override
            public void doSelect(PlainSelect plainSelect) {
                //Implementation goes here
            }

            @Override
            public void doUpdate(Table table, Update update) {
                //Implementation goes here
            }
        });
    }

    @Test
    public void parseUpdateTest() throws JSQLParserException {
        SQLParser parser = new SQLParser("UPDATE table1 SET table1.column=value1");
        parser.execute(new Builder() {
            @Override
            public String getResult() {
                return null;  //Implementation goes here
            }

            @Override
            public void doSelect(PlainSelect plainSelect) {
                //Implementation goes here
            }

            @Override
            public void doUpdate(Table table, Update update) {
                //Implementation goes here
            }
        });
    }
}
