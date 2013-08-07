package com.anyconsole.db;

import com.anyconsole.core.parser.Parser;
import com.anyconsole.core.parser.SQLParser;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import net.sf.jsqlparser.JSQLParserException;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

@Component
public class MongoPlugin implements Plugin {

    private Mongo mongoClient;

    @Override
    public Parser parse(String statement) {
        try {
            return new SQLParser(statement);
        } catch (JSQLParserException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String execute(Parser parser) {
        try {
            return parser.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // let's assume for now that db is localhost and has no credentials. MS.
    public DB getDatastore(String dbName) {
        return getClient().getDB(dbName);
    }

    private Mongo getClient() {
        if (mongoClient == null) {
            try {
                mongoClient = new Mongo("localhost" , 27017 );
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            } catch (MongoException e) {
                throw new RuntimeException(e);
            }
        }
        return mongoClient;
    }
}