package com.anyconsole.core.command;

import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.update.Update;

public class MongoCommandBuilder implements CommandBuilder {

    private MongoCommand command;

    public MongoCommandBuilder() {
    }

    @Override
    public Command getCommand() {
        return command;
    }

    @Override
    public void buildSelect(PlainSelect plainSelect) {
        final SelectMongoCommand selectMongoCommand = new SelectMongoCommand();
        selectMongoCommand.withSelect(plainSelect);
        this.command = selectMongoCommand;
    }

    @Override
    public void buildUpdate(Table table, Update update) {
        final UpdateMongoCommand updateCommand = new UpdateMongoCommand();
        updateCommand.withCollection(table.getName());
        updateCommand.withUpdate(update);
        this.command = updateCommand;
    }
}
