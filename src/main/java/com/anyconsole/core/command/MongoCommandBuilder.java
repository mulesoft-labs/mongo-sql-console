package com.anyconsole.core.command;

import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.FromItemVisitor;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SubJoin;
import net.sf.jsqlparser.statement.select.SubSelect;
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
        plainSelect.getFromItem().accept(new FromItemVisitor() {
            
            @Override
            public void visit(SubJoin arg0) {
            }
            
            @Override
            public void visit(SubSelect arg0) {
            }
            
            @Override
            public void visit(Table arg0) {
                selectMongoCommand.withCollection(arg0.getName());
            }
        });
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
