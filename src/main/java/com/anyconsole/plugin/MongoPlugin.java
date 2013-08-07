package com.anyconsole.plugin;

import com.anyconsole.core.command.MongoCommandBuilder;
import com.anyconsole.core.command.Result;
import com.anyconsole.core.parser.Parser;
import com.anyconsole.core.parser.SQLParser;
import net.sf.jsqlparser.JSQLParserException;
import org.springframework.stereotype.Component;

@Component("mongo-plugin")
public class MongoPlugin implements Plugin {

    @Override
    public Parser parse(String statement) {
        try {
            return new SQLParser(statement);
        } catch (JSQLParserException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String execute(Parser parser) {
        try {
            MongoCommandBuilder commandBuilder = new MongoCommandBuilder();
            parser.execute(commandBuilder);

            Result result = commandBuilder.getCommand().execute();
            return result.getStringResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}