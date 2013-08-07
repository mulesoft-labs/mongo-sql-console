package com.anyconsole.api;

import com.sun.jersey.api.core.ResourceContext;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

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

    @Path("/mongo")
    public MongoResource getMongoResource() {
        return resourceContext.getResource(MongoResource.class);
    }
}
