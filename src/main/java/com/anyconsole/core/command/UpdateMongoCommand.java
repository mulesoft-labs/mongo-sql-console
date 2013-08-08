package com.anyconsole.core.command;

import com.anyconsole.core.command.visitor.MongoWhereExprVisitor;
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
        DBCollection coll = mongoClient.getDatastore().getCollection(collection);

        List<Column> colNames = update.getColumns();
        List<Expression> values = update.getExpressions();

        BasicDBObject updateExpr = new BasicDBObject();
        BasicDBObject statement = new BasicDBObject("$set", updateExpr);
        for (int i = 0; i < colNames.size(); ++i) {
            updateExpr.append(colNames.get(i).getColumnName(),
                    MongoStringUtils.trimSingleQuotes(values.get(i).toString()));
        }

        BasicDBObject where = new BasicDBObject();
        MongoWhereExprVisitor exprVisitor = new MongoWhereExprVisitor(where);

        Expression updateWhere = update.getWhere();
        if (updateWhere != null) {
            updateWhere.accept(exprVisitor);
        }

        WriteResult wr = coll.update(exprVisitor.getExpression(), statement);
        return new MongoResult(wr.toString());
    }

}
