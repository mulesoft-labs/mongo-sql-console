package com.anyconsole.core.builder;

import com.anyconsole.core.builder.visitor.MongoWhereExprVisitor;
import com.anyconsole.core.client.MongoClient;
import com.anyconsole.util.MongoStringUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.WriteResult;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.update.Update;

import java.util.List;

public class MongoExpressionBuilder implements Builder {
	private String result = "";
    private MongoClient mongoClient;

	public MongoExpressionBuilder(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}
	
	@Override
	public String getResult() {
		return result;
	}

	@Override
	public void doSelect(PlainSelect plainSelect) {
		DBCollection coll = mongoClient.getDatastore().getCollection(plainSelect.getFromItem().getAlias());

	}

	@Override
	public void doUpdate(Table table, Update update) {
		DBCollection coll = mongoClient.getDatastore().getCollection(table.getName());

        List<Column> colNames = update.getColumns();
		List<Expression> values = update.getExpressions();

		BasicDBObject updateExpr = new BasicDBObject();
		BasicDBObject statement = new BasicDBObject("$set", updateExpr);
		for (int i = 0; i < colNames.size(); ++i) {
			updateExpr.append(colNames.get(i).getColumnName(), MongoStringUtils.trimSingleQuotes(values.get(i).toString()));
		}
		
		BasicDBObject where = new BasicDBObject();
		MongoWhereExprVisitor exprVisitor = new MongoWhereExprVisitor(where);
		Expression updateWhere = update.getWhere();
		if (updateWhere != null) {
			updateWhere.accept(exprVisitor);
		}
			
		WriteResult wr = coll.update(exprVisitor.getExpression(), statement);
		result = wr.toString();
	}

}
