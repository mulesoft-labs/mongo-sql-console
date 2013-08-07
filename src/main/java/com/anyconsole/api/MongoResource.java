package com.anyconsole.api;

import com.anyconsole.core.parser.Parser;
import com.anyconsole.plugin.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;

/**
 * User: kbabushkin
 * Date: 8/6/13
 */

@Consumes("application/json")
@Produces("application/json")
@Component("mongo-resource")
public class MongoResource {

    @Autowired
	private Plugin mongoPlugin;

    @POST
    public String post(String statement) throws Exception {
        // mongoPlugin.parse
        // if parse failed return 404 + message
        // if parse succeeded call execute and return result

        Parser parser = mongoPlugin.parse(statement);
        return mongoPlugin.execute(parser);
    }
}
