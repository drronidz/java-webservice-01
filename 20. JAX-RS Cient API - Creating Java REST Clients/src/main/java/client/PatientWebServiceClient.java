package client;

/*
PROJECT NAME : 20. JAX-RS Cient API - Creating Java REST Clients
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 07/02/2022 23:43
*/



import com.diogonunes.jcolor.Attribute;
import model.Patient;

import javax.ws.rs.client.*;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class PatientWebServiceClient {

    public static final String PATIENT_SERVICE_URL = "http://localhost:8080/restws/services/patientservice";
    public static final Attribute backgroundColor = BACK_COLOR(39, 179, 118);
    public static final Attribute textColor = TEXT_COLOR(0, 0, 0);
    public static final String PATIENTS = "/patients";

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();

        Patient patient = getMethod(client);

        updateMethod(client, patient);

        createMethod(client);

    }

    private static Patient getMethod(Client client) {
        WebTarget getTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS).path("/{id}").resolveTemplate("id", 1);
//        target.resolveTemplate("id", 1);
        Builder request = getTarget.request();
//        Response response = request.get();
        Patient patient = request.get(Patient.class);
        System.out.println(colorize(String.valueOf(patient), BOLD(), textColor, backgroundColor));
        return patient;
    }

    private static void updateMethod(Client client, Patient patient) {
        System.out.println(colorize(String.valueOf("Old Patient:" + patient), BOLD(), textColor, backgroundColor));
        patient.setName("NEW NAME");
        WebTarget putTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS);
//        Response updateResponse = putTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));
        Patient updatedPatient = putTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML), Patient.class);

        System.out.println(colorize(String.valueOf("Updated Patient:" + updatedPatient), BOLD(), textColor, backgroundColor));
    }

    private static void createMethod(Client client) {
        Patient newPatient = new Patient();
        newPatient.setName("James");
        WebTarget postTarget = client.target(PATIENT_SERVICE_URL).path(PATIENTS);
        Patient createdPatient = postTarget.request().post(Entity.entity(newPatient, MediaType.APPLICATION_XML),Patient.class);

        System.out.println(colorize("Created Patient:" + createdPatient, BOLD(), textColor, backgroundColor));
    }
}
