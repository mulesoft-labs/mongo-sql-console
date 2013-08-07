package com.anyconsole.core.command;

import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.update.Update;

public interface CommandBuilder {

	Command getCommand();

	void buildSelect(PlainSelect plainSelect);

	void buildUpdate(Table table, Update update);

}
