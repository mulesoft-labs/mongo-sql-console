package com.anyconsole.core.command;

import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.update.Update;

public class MongoCommandBuilder implements CommandBuilder {

    private MongoCommand command = new MongoCommand();

	public MongoCommandBuilder() {
	}
	
	@Override
	public Command getCommand() {
		return command;
	}

	@Override
	public void buildSelect(PlainSelect plainSelect) {
        //TODO: implement command construction
		//DBCollection coll = mongoClient.getDatastore().getCollection(plainSelect.getFromItem().getAlias());
	}

	@Override
	public void buildUpdate(Table table, Update update) {
        //TODO: implement command construction
		/*DBCollection coll = mongoClient.getDatastore().getCollection(table.getName());

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
		result = wr.toString();*/
	}
}
