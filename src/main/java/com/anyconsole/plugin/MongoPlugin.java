package com.anyconsole.plugin;

import com.anyconsole.core.builder.MongoExpressionBuilder;
import com.anyconsole.core.client.MongoClient;
import com.anyconsole.core.parser.Parser;
import com.anyconsole.core.parser.SQLParser;
import net.sf.jsqlparser.JSQLParserException;
import org.springframework.stereotype.Component;

@Component
public class MongoPlugin implements Plugin {

    private MongoClient mongoClient = new MongoClient();

	@Override
	public Parser parse(String statement) {
		try {
			return new SQLParser(statement);
		} catch (JSQLParserException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String execute(Parser parser) {
		try {
            //TODO: builder should not actual select/update
			return parser.execute(new MongoExpressionBuilder(mongoClient));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}