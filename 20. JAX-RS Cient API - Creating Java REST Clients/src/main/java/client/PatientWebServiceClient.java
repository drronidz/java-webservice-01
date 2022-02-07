package client;

/*
PROJECT NAME : 20. JAX-RS Cient API - Creating Java REST Clients
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 07/02/2022 23:43
*/



import com.diogonunes.jcolor.Attribute;
import model.Patient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class PatientWebServiceClient {

    public static final String PATIENT_SERVICE_URL = "http://localhost:8080/restws/services/patientservice";

    public static void main(String[] args) {
        Attribute backgroundColor = BACK_COLOR(39, 179, 118);
        Attribute textColor = TEXT_COLOR(0, 0, 0);

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(PATIENT_SERVICE_URL).path("/patients").path("/{id}").resolveTemplate("id", 1);

//        target.resolveTemplate("id", 1);

        Builder request = target.request();

//        Response response = request.get();
        Patient patient = request.get(Patient.class);

        System.out.println(colorize(String.valueOf(patient), BOLD(), textColor, backgroundColor));
    }
}
