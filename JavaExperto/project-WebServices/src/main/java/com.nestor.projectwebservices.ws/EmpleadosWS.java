package com.nestor.projectwebservices.ws;

import com.nestor.projectwebservices.entity.Empleado;
import com.nestor.projectwebservices.service.EmpleadoService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("empleadosWS") //Nombre al cual acceder al web service
public class EmpleadosWS {

    private final EmpleadoService empleadoService = new EmpleadoService();


    @GET
    @Path("test")
    public String test() {

        return "Example webservice con Jersey";
    }

    @GET
    @Path("consultarEmpleado")
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public Empleado consultarEmpleado() {
        return this.empleadoService.consultarEmpleado();
    }

    @GET
    @Path("consultarListaEmpleados")
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public List<Empleado> consultarListaEmpleados() {
        return this.empleadoService.consultarListaEmpleados();
    }


}
