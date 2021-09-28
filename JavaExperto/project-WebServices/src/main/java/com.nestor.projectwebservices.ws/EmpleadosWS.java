package com.nestor.projectwebservices.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("empleadosWS") //Nombre al cual acceder al web service
public class EmpleadosWS {

    @Path("test")
    @GET
    public String test(){

        return "Example webservice con Jersey";
    }
}
