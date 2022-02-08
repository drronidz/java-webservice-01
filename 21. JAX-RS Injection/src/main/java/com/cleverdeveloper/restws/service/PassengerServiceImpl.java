package com.cleverdeveloper.restws.service;

/*
PROJECT NAME : 21. JAX-RS Injection
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 08/02/2022 19:17
*/

import com.cleverdeveloper.restws.model.Passenger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    List<Passenger> passengers = new ArrayList<>();
    int currentId = 0;

    @Override
    public List<Passenger> getPassengers() {
        return passengers;
    }

    @Override
    public Passenger addPassenger(Passenger passenger) {
        passenger.setId(++currentId);
        passengers.add(passenger);
        return passenger;
    }
}
