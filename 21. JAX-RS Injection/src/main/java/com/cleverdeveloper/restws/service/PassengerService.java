package com.cleverdeveloper.restws.service;

/*
PROJECT NAME : 21. JAX-RS Injection
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 08/02/2022 19:16
*/

import com.cleverdeveloper.restws.model.Passenger;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import java.util.List;

@Path("/passengerservice")
@Produces("application/xml")
@Consumes("application/xml,application/x-www-form-urlencoded")
public interface PassengerService {

    @Path("/passengers")
    @GET
    List<Passenger> getPassengers(@QueryParam("start") int start, @QueryParam("size") int size);

    @Path("/passengers")
    @POST
    void addPassenger(@FormParam("firstName") String firstName,
                      @FormParam("lastName") String lastName,
                      @Context HttpHeaders headers,
                      @HeaderParam("agent") String agent);


}
