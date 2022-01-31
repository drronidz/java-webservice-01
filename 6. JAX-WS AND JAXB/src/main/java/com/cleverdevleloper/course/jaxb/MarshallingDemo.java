package com.cleverdevleloper.course.jaxb;

/*
PROJECT NAME : 6. JAX-WS AND JAXB
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 01/02/2022 00:22
*/

import com.cleverdeveloper.patient.Patient;
import com.diogonunes.jcolor.Attribute;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringWriter;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class MarshallingDemo {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        /* @Class (Attribute):  class is used to colorize inputs inside the console*/
        /* @Parameter 1 (backgroundColor) : is used for the background color */
        /* @Parameter 2 (textColor): is used for the text color */
        Attribute backgroundColor = BACK_COLOR(39, 179, 118);
        Attribute textColor = TEXT_COLOR(45, 45, 45);

        /*********** The process of Marshalling ***********/

        System.out.println(colorize("\t######### The process of Marshalling #########\t", BOLD(), textColor, backgroundColor));

        // Setting up the context (the main entry point)
        /*
        * @param: is the aimed class "Patient" ...
        * */
        JAXBContext context = JAXBContext.newInstance(Patient.class);

        // Creating a Marshaller
        Marshaller marshaller = context.createMarshaller();

        /* Creating a new patient */
        Patient patient = new Patient();
        patient.setId(123);
        patient.setName("DIAB");

        /**
         * @Param 1 : it is the actual JAXB element which should be marshalled (patient in our case).
         * @param 2 : it is a handler (output stream) which we want this XML to be written (StringWriter in our case).
         */
        StringWriter writer = new StringWriter();
        marshaller.marshal(patient, writer);
        marshaller.marshal(patient, new FileOutputStream("src/main/resources/xml/patient.xml"));

        /* Printing the content of the writer. */
        System.out.println(writer.toString());
    }
}
