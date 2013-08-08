package com.anyconsole.core.command;

import com.anyconsole.core.client.MongoClient;
import com.anyconsole.core.command.visitor.MongoColumnsExpressionVisitor;
import com.anyconsole.core.command.visitor.MongoWhereExpressionVisitor;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.AllColumns;
import net.sf.jsqlparser.statement.select.AllTableColumns;
import net.sf.jsqlparser.statement.select.FromItemVisitor;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectItem;
import net.sf.jsqlparser.statement.select.SelectItemVisitor;
import net.sf.jsqlparser.statement.select.SubJoin;
import net.sf.jsqlparser.statement.select.SubSelect;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public final class SelectMongoCommand extends MongoCommand {

    private PlainSelect select;
    private boolean selectAll = false;

    public SelectMongoCommand withSelect(PlainSelect select) {
        this.select = select;
        this.select.getFromItem().accept(new FromItemVisitor() {
            @Override
            public void visit(SubJoin subJoin) {
            }

            @Override
            public void visit(SubSelect subSelect) {
            }

            @Override
            public void visit(Table table) {
                collection = table.getName();
            }
        });
        return this;
    }

    @Override
    public Result execute() {
        final MongoColumnsExpressionVisitor columnsExprVisitor = new MongoColumnsExpressionVisitor();
        final ListIterator<SelectItem> iterator = select.getSelectItems().listIterator();

        while (iterator.hasNext()) {
            iterator.next().accept(new SelectItemVisitor() {
                @Override
                public void visit(AllColumns allColumns) {
                    selectAll = true;
                }

                @Override
                public void visit(AllTableColumns allTableColumns) {
                }

                @Override
                public void visit(SelectExpressionItem selectExpressionItem) {
                    selectExpressionItem.getExpression().accept(columnsExprVisitor);
                }
            });
        }

        BasicDBObject columnsExpr = columnsExprVisitor.getExpression();
        if(!selectAll && !columnsExpr.containsField("_id")) {
            columnsExpr.append("_id", 0);
        }

        MongoWhereExpressionVisitor whereExprVisitor = new MongoWhereExpressionVisitor();
        Expression updateWhere = select.getWhere();
        if (updateWhere != null) {
            updateWhere.accept(whereExprVisitor);
        }

        DBCollection mongoCollection = MongoClient.getDatastore().getCollection(collection);
        DBCursor cursor = mongoCollection.find(whereExprVisitor.getExpression(), columnsExpr);

        List<DBObject> resultList = new ArrayList<DBObject>();
        try {
            while (cursor.hasNext()) {
                resultList.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return new MongoResult<String>(JSON.serialize(resultList));
    }

}
