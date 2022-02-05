package com.cleverdeveloper.restful.service;

/*
PROJECT NAME : 17. RESTFul Design and Implementation
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 05/02/2022 13:36
*/

import com.cleverdeveloper.restful.model.Patient;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/patientservice")
public interface PatientService {

    @Path("/patients")
    @GET
    List<Patient> getPatients();

    @Path("/patients/{id}")
    @GET
    Patient getPatient(@PathParam(value = "id") Long id);

    @Path("/patients")
    @POST
    Response createPatient(Patient patient);
}
