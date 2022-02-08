package com.cleverdeveloper.restws.service;

/*
PROJECT NAME : 21. JAX-RS Injection
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 08/02/2022 19:16
*/

import com.cleverdeveloper.restws.model.Passenger;

import javax.ws.rs.*;
import java.util.List;

@Path("/passengerservice")
@Produces("application/xml")
@Consumes("application/xml")
public interface PassengerService {

    @Path("/passengers")
    @GET
    List<Passenger> getPassengers();

    @Path("/passengers")
    @POST
    Passenger addPassenger(Passenger passenger);
}
