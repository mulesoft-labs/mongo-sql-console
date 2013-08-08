package com.anyconsole.core.command;

import com.anyconsole.core.client.MongoClient;
import com.anyconsole.core.command.visitor.MongoWhereExpressionVisitor;
import com.anyconsole.util.MongoStringUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.WriteResult;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.update.Update;

import java.util.List;

public final class UpdateMongoCommand extends MongoCommand {

    private Update update;

    public UpdateMongoCommand withUpdate(Update update) {
        this.update = update;
        return this;
    }

    @Override
    public Result execute() {
        List<Column> colNames = update.getColumns();
        List<Expression> values = update.getExpressions();

        BasicDBObject updateExpr = new BasicDBObject();
        for (int i = 0; i < colNames.size(); ++i) {
            updateExpr.append(colNames.get(i).getColumnName(),
                    MongoStringUtils.trimSingleQuotes(values.get(i).toString()));
        }

        MongoWhereExpressionVisitor whereExprVisitor = new MongoWhereExpressionVisitor();
        Expression updateWhere = update.getWhere();
        if (updateWhere != null) {
            updateWhere.accept(whereExprVisitor);
        }

        DBCollection coll = MongoClient.getDatastore().getCollection(collection);
        WriteResult wr = coll.update(whereExprVisitor.getExpression(), new BasicDBObject("$set", updateExpr));

        return new MongoResult<String>(wr.getError() == null ? "" : wr.getError());
    }

}
