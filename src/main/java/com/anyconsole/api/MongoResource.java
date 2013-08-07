package com.anyconsole.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import com.anyconsole.db.Plugin;

/**
 * User: kbabushkin
 * Date: 8/6/13
 */

@Consumes("application/json")
@Produces("application/json")
@Component("mongo-resource")
public class MongoResource {
	
	private Plugin mongoPlugin;

    @GET
    private String get() {
    	// mongoPlugin.parse
    	// if parse failed return 404 + message
    	// if parse succeeded call execute and return result
        return null;
    }
}
