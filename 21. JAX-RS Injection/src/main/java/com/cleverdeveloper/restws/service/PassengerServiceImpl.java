package com.cleverdeveloper.restws.service;

/*
PROJECT NAME : 21. JAX-RS Injection
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 08/02/2022 19:17
*/

import com.cleverdeveloper.restws.model.Passenger;
import com.diogonunes.jcolor.Attribute;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;

@Service
public class PassengerServiceImpl implements PassengerService {

    List<Passenger> passengers = new ArrayList<>();
    int currentId = 0;

    Attribute bgOne = BACK_COLOR(39, 179, 118);
    Attribute bgTwo = BACK_COLOR(39, 50, 118);
    Attribute bgThree = BACK_COLOR(39, 255, 118);
    Attribute textColor = TEXT_COLOR(0, 0, 0);


    /*
     * Giving the option of paging to client.
     * @param start: starting point.
     * @param size: size of the page.
     * */
    @Override
    public List<Passenger> getPassengers(int start, int size) {
        System.out.println(start);
        System.out.println(size);
        return passengers;
    }

    @Override
    public void addPassenger(String firstName, String lastName, HttpHeaders headers, String agent) {
        System.out.println(colorize(firstName + " " + lastName + " for agent : " + agent, BOLD(), textColor, bgOne));

        MultivaluedMap<String, String> allHeaders = headers.getRequestHeaders();
        Set<String> headersKeys = allHeaders.keySet();

        for (String key: headersKeys) {
            System.out.println(colorize(key + " : " + headers.getHeaderString(key), BOLD(), textColor, bgTwo));
        }

        Map<String, Cookie> cookies = headers.getCookies();
        Set<String> cookieKeys = cookies.keySet();

        for (String cookieKey: cookieKeys) {
            System.out.println("--------------- Cookies ---------------");
            System.out.println(colorize(cookieKey + " : " + cookies.get(cookieKey).getValue(), BOLD(), textColor, bgThree));
        }
    }
}
