package com.cleverdeveloper.restful.service;

import com.cleverdeveloper.restful.model.Patient;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.*;

/*
PROJECT NAME : 17. RESTFul Design and Implementation
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 05/02/2022 13:37
*/
@Service
public class PatientServiceImpl implements PatientService {

    Map<Long, Patient> patients = new HashMap<>();
    long currentId = 0;

    public PatientServiceImpl() {
        init();
    }

    void init() {
        Patient patient = new Patient();
        patient.setId(++currentId);
        patient.setName("John");

        patients.put(patient.getId(), patient);

    }

    @Override
    public List<Patient> getPatients() {
        Collection<Patient> response = patients.values();
        return new ArrayList(response);
    }

    @Override
    public Patient getPatient(Long id) {
        if (patients.get(id) == null) {
//            throw new WebApplicationException(Response.Status.NOT_FOUND);
            throw new NotFoundException();
        }
        return patients.get(id);
    }

    @Override
    public Response createPatient(Patient patient) {
        patient.setId(++currentId);
        patients.put(patient.getId(), patient);

        return Response.ok(patient).build();
    }

    @Override
    public Response updatePatient(Patient patient) {
        Patient currentPatient = patients.get(patient.getId());

        Response response;
        if(currentPatient != null) {
            patients.put(patient.getId(), patient);
            response = Response.ok(patient).build();
        } else {
            response = Response.notModified().build();
        }
        return response;
    }

    @Override
    public Response deletePatient(Long id) {
        Patient patient = patients.get(id);
        Response response;

        if (patient != null) {
            patients.remove(id);
            response = Response.ok().build();
        } else {
            response = Response.notModified().build();
        }
        return response;
    }
}
