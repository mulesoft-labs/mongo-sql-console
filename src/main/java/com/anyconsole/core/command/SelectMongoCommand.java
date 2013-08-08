package com.anyconsole.core.command;

import com.anyconsole.core.command.visitor.MongoWhereExprVisitor;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.FromItemVisitor;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SubJoin;
import net.sf.jsqlparser.statement.select.SubSelect;

public final class SelectMongoCommand extends MongoCommand {

    private PlainSelect select;

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
        DBCollection mongoCollection = mongoClient.getDatastore().getCollection(collection);

        //TODO: add columns select

        BasicDBObject where = new BasicDBObject();
        MongoWhereExprVisitor exprVisitor = new MongoWhereExprVisitor(where);

        Expression updateWhere = select.getWhere();
        if (updateWhere != null) {
            updateWhere.accept(exprVisitor);
        }

        DBCursor cursor = mongoCollection.find(exprVisitor.getExpression());
        StringBuilder sb = new StringBuilder();
        try {
            while (cursor.hasNext()) {
                DBObject object = cursor.next();
                String json = JSON.serialize(object);
                sb.append(json);
                sb.append("\n");
            }
        } finally {
            cursor.close();
        }
        return new MongoResult(sb.toString());
    }

}
