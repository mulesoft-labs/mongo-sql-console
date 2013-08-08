package com.anyconsole.api;

import com.anyconsole.core.command.Result;
import com.anyconsole.core.parser.Parser;
import com.anyconsole.plugin.Plugin;
import net.sf.jsqlparser.JSQLParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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
    public Response post(String statement) {
        try {
            Parser parser = mongoPlugin.parse(statement);
            Result result = mongoPlugin.execute(parser);

            return Response.ok(result.getResult()).build();
        } catch (JSQLParserException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Parsing error: " + e.getCause()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Unexpected error: " + e.getCause()).build();
        }
    }
}
