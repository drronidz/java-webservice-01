package com.cleverdeveloper.restws.client;

/*
PROJECT NAME : 22. Asynchronous REST
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 09/02/2022 22:20
*/

import com.cleverdeveloper.restasync.model.CheckList;
import com.diogonunes.jcolor.Attribute;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

public class CheckProcessingClient {
    public static void main(String[] args)  {
        Attribute bgOne = BACK_COLOR(39, 179, 118);
        Attribute bgTwo = BACK_COLOR(39, 50, 118);
        Attribute bgThree = BACK_COLOR(39, 255, 118);
        Attribute textColor = TEXT_COLOR(0, 0, 0);

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("http://localhost:8080/restwsasync/services/checkprocessingservice/checklist");
        AsyncInvoker invoker = target.request().async();

        Future<Boolean> response = invoker.post(Entity.entity(new CheckList(), MediaType.APPLICATION_XML), Boolean.class);
        try {
            System.out.println(colorize(String.valueOf(response.get()), textColor, bgOne));
        }  catch (InterruptedException exception) {
            exception.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();

            if (e.getCause() instanceof  BadRequestException) {
                System.out.println(colorize("Please send a valid list of checks ...", textColor, bgTwo));
            }
        }
    }
}
