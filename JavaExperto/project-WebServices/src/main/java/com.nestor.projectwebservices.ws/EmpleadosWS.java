package com.nestor.projectwebservices.ws;

import com.nestor.projectwebservices.entity.Empleado;
import com.nestor.projectwebservices.service.EmpleadoService;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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


//    @GET
//    @Path("consultarEmpleadoById/{numEmp}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Empleado consultarEmpleadoById(@PathParam("numEmp") String numeroEmpleado) {
//        return this.empleadoService.consultarEmpleadoById(numeroEmpleado);
//    }

    @GET
    @Path("consultarEmpleadoById/{numEmp}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarEmpleadoById(@PathParam("numEmp") String numeroEmpleado) {
        Empleado empleadoConsultado = this.empleadoService.consultarEmpleadoById(numeroEmpleado);
        if (empleadoConsultado == null) {
            return Response.noContent().build();

        }

        GenericEntity<Empleado> empleadoGenericEntity = new GenericEntity<>(empleadoConsultado, Empleado.class);
        //return Response.ok(empleadoConsultado).build();
        return Response.ok(empleadoGenericEntity).build();

    }


    @POST
    @Path("guardarEmpleado")
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardarEmpleado(Empleado empleado) {

        if (empleado == null) {
            return Response.status(400).entity("No se ingreso información").build();
        }
        if(empleado.getNumeroEmpleado() == null || empleado.getNumeroEmpleado().isEmpty()){
            return Response.status(400).entity("El numero de empleado es requerido").build();
        }
        if (empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
            return Response.status(400).entity("No se ingreso nombre").build();
        }

        GenericEntity<Empleado> empleadoGeneric = new GenericEntity<>(empleado, Empleado.class);
        return Response.ok(empleadoGeneric).build();

    }


}
