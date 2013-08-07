package com.anyconsole.api;

import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * User: kbabushkin
 * Date: 8/6/13
 */

@Consumes("application/json")
@Produces("application/json")
@Component("mongo-resource")
public class MongoResource {

    @GET
    private String get() {
        return null;
    }
}
