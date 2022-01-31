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
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class UnmarshallingDemo {
    public static void main(String[] args) throws JAXBException {
        Attribute backgroundColor = BACK_COLOR(39, 179, 118);
        Attribute textColor = TEXT_COLOR(45, 45, 45);

        /*********** The process of UNMarshalling ***********/
        System.out.println(colorize("\t######### The process of Unmarshalling #########\t", BOLD(), textColor, backgroundColor));

        //getting the xml file to read
        File file = new File("src/main/resources/xml/patient.xml");

        JAXBContext context = JAXBContext.newInstance(Patient.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        Patient patientResult = (Patient) unmarshaller.unmarshal(file);

        System.out.println(patientResult.toString());
    }
}
