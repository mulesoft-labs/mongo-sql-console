package com.anyconsole.db;

import java.net.UnknownHostException;

import org.springframework.stereotype.Component;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

@Component
public class MongoPlugin implements Plugin {
	
	private Mongo mongoClient;

	@Override
	public Parser parse(String statement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(Parser parser) {
		// TODO Auto-generated method stub
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
