package com.anyconsole.api;

import com.anyconsole.core.parser.SQLKeyword;
import com.sun.jersey.api.core.ResourceContext;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.HashSet;

/**
 * User: kbabushkin
 * Date: 8/6/13
 */

@Path("/")
@Consumes("application/json")
@Produces("application/json")
@Component("any-console-resource")
public class AnyConsoleResource {

    @Context
    private ResourceContext resourceContext;

    @GET
    @Path("keywords")
    public Response getSQLKeywords() {
    	return Response.ok(new HashSet<SQLKeyword>(Arrays.asList(SQLKeyword.values()))).build();
    }

    @Path("mongo")
    public MongoResource getMongoResource() {
        return resourceContext.getResource(MongoResource.class);
    }
}
