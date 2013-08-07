package com.anyconsole.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * User: kbabushkin
 * Date: 8/6/13
 */

@Path("/api")
@Consumes("application/json")
@Produces("application/json")
@Component("any-console-resource")
public class AnyConsoleResource {

    @Autowired
    private  MongoResource mongoResource;

    @Path("/mongo")
    public MongoResource getMongoResource() {
        return mongoResource;
    }
}
