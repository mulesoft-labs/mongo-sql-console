package com.anyconsole.core.parser;

import com.anyconsole.db.Builder;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.StatementVisitor;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.create.view.CreateView;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.drop.Drop;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.replace.Replace;
import net.sf.jsqlparser.statement.select.IntoTableVisitor;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectVisitor;
import net.sf.jsqlparser.statement.select.SetOperationList;
import net.sf.jsqlparser.statement.truncate.Truncate;
import net.sf.jsqlparser.statement.update.Update;

/**
 * User: kbabushkin
 * Date: 8/6/13
 */

public class SQLStatementVisitor implements StatementVisitor {
	private Builder builder;

    public SQLStatementVisitor(Builder builder) {
		this.builder = builder;
	}

	public String getResult() {
        return builder.getResult();
    }

    @Override
    public void visit(Select select) {
        select.getSelectBody().accept(new SelectVisitor() {
            @Override
            public void visit(PlainSelect plainSelect) {
                builder.doSelect(plainSelect);
            }

            @Override
            public void visit(SetOperationList setOperationList) {
            }
        });
    }

    @Override
    public void visit(Delete delete) {
        //Implementation goes here
    }

    @Override
    public void visit(final Update update) {
        update.getTable().accept(new IntoTableVisitor() {
            @Override
            public void visit(Table table) {
            	 builder.doUpdate(table, update);
            }
        });
    }

    @Override
    public void visit(Insert insert) {
        //Implementation goes here
    }

    @Override
    public void visit(Replace replace) {
        //Implementation goes here
    }

    @Override
    public void visit(Drop drop) {
        //Implementation goes here
    }

    @Override
    public void visit(Truncate truncate) {
        //Implementation goes here
    }

    @Override
    public void visit(CreateTable createTable) {
        //Implementation goes here
    }

    @Override
    public void visit(CreateView createView) {
        //Implementation goes here
    }
}
