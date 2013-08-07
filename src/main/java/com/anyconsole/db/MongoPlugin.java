package com.anyconsole.db;

import java.net.UnknownHostException;
import java.util.Set;

import net.sf.jsqlparser.JSQLParserException;

import org.springframework.stereotype.Component;

import com.anyconsole.core.parser.Parser;
import com.anyconsole.core.parser.SQLParser;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.WriteResult;

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
	
	private String executeSelect(DB db) {
		StringBuilder result = new StringBuilder();
		DBCollection coll = db.getCollection("testCollection");
		DBCursor cursor = coll.find(new BasicDBObject("i", new BasicDBObject("$gt", 50)));
		try {
			   while(cursor.hasNext()) {
				   result.append(cursor.next().toString());
			   }
			} finally {
			   cursor.close();
			}

		return result.toString();
	}
	
	private String executeInsert(DB db) {
		DBCollection coll = db.getCollection("testCollection");
		BasicDBObject doc = new BasicDBObject("name", "MongoDB").
                append("type", "database").
                append("count", 1).
                append("info", new BasicDBObject("x", 203).append("y", 102));

		coll.insert(doc);
		return doc.getObjectId("_id").toString();
	}
	
	private String executeUpdate(DB db) {
		DBCollection coll = db.getCollection("testCollection");
		BasicDBObject doc = new BasicDBObject("name", "MongoDB").
                append("type", "database").
                append("count", 1).
                append("info", new BasicDBObject("x", 203).append("y", 102));

		WriteResult wr = coll.updateMulti(new BasicDBObject("i", new BasicDBObject("$gt", 50)), doc);
		return wr.toString();
	}
	
	private Set<String> showDatabases(DB db) {
		return db.getCollectionNames();
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
