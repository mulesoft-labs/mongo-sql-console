package com.anyconsole.plugin;

import com.anyconsole.core.command.MongoCommandBuilder;
import com.anyconsole.core.command.Result;
import com.anyconsole.core.parser.Parser;
import com.anyconsole.core.parser.SQLParser;
import org.springframework.stereotype.Component;

@Component("mongo-plugin")
public class MongoPlugin implements Plugin {

    @Override
    public Parser parse(String statement) throws Exception {
       return new SQLParser(statement);
    }

    @Override
    public Result execute(Parser parser) throws Exception {
        MongoCommandBuilder commandBuilder = new MongoCommandBuilder();
        parser.execute(commandBuilder);

        return commandBuilder.getCommand().execute();
    }
}