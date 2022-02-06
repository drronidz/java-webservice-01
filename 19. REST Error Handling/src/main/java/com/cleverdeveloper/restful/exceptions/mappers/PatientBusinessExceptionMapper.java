package com.cleverdeveloper.restful.exceptions.mappers;

/*
PROJECT NAME : 19. REST Error Handling
Module NAME: IntelliJ IDEA
Author Name : @ DRRONIDZ
DATE : 06/02/2022 21:58
*/

import com.cleverdeveloper.restful.exceptions.PatientBusinessException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PatientBusinessExceptionMapper implements ExceptionMapper<PatientBusinessException> {


    @Override
    public Response toResponse(PatientBusinessException e) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("\"status\":\"error\"");
        stringBuilder.append(",");
        stringBuilder.append("\"message\":\"Try Again Later\"");
        stringBuilder.append("}");

        return Response.serverError().entity(stringBuilder.toString()).type(MediaType.APPLICATION_JSON).build();
    }
}
