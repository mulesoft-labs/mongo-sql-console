package com.anyconsole.core.builder;

import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.update.Update;

public interface Builder {

	String getResult();

	void doSelect(PlainSelect plainSelect);

	void doUpdate(Table table, Update update);

}
