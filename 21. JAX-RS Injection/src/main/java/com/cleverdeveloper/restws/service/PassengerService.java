package com.cleverdeveloper.restws.service;

/*
PROJECT NAME : 21. JAX-RS Injection
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 08/02/2022 19:16
*/

import com.cleverdeveloper.restws.model.Passenger;

import java.util.List;

public interface PassengerService {

    List<Passenger> getPassengers();

    Passenger addPassenger();
}
