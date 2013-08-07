package com.anyconsole.api;

import com.anyconsole.core.parser.SQLKeyword;
import com.sun.jersey.api.core.ResourceContext;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User: kbabushkin
 * Date: 8/6/13
 */

@Path("/api")
@Consumes("application/json")
@Produces("application/json")
@Component("any-console-resource")
public class AnyConsoleResource {

    @Context
    private ResourceContext resourceContext;

    @GET
    @Path("keywords")
    public Set<SQLKeyword> getSQLKeywords() {
    	return new HashSet<SQLKeyword>(Arrays.asList(SQLKeyword.values()));
    }

    @Path("mongo")
    public MongoResource getMongoResource() {
        return resourceContext.getResource(MongoResource.class);
    }
}
