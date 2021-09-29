package com.nestor.projectwebservicesconsumer.client;

import com.nestor.projectwebservicesconsumer.dto.EmpleadoDTO;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;

/**
 * Clase cliente que permite consumir los WebService de Empleados
 */

public class EmpleadoWSCliente {

    public static void main(String[] args) {

        // ::::::::: GET:::::::::
        /*
        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target("http://localhost:8080/project_WebServices_war_exploded/nestor/empleadosWS").path("consultarEmpleadoById").path("123456");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.get();

        if (response.getStatus() == 204) {
            System.out.println("No se encontró el empleado con el numero de empleado");
        }
        if (response.getStatus() == 200) {
            EmpleadoDTO empleadoDTO = response.readEntity(EmpleadoDTO.class);

            System.out.println("Nombre empleado: " + empleadoDTO.getNombre());
            System.out.println("Fecha creacion: " + empleadoDTO.getFechaCreacion());
        }*/

        //::::::: POST ::::::::;

        Client cliente = ClientBuilder.newClient();
        WebTarget webTarget = cliente.target("http://localhost:8080/project_WebServices_war_exploded/nestor/empleadosWS/").path("guardarEmpleado");

        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        //empleadoDTO.setNumeroEmpleado("123");
        //empleadoDTO.setNombre("Enviar 1");
        empleadoDTO.setPrimerApellido("Apellido");
        empleadoDTO.setSegundoApellido("Apellido 2");
        empleadoDTO.setEdad(30);
        empleadoDTO.setFechaCreacion(LocalDateTime.now());

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = invocationBuilder.post(Entity.entity(empleadoDTO, MediaType.APPLICATION_JSON_TYPE));

//        System.out.println(response.getStatus());
//        System.out.println(response.readEntity(String.class));

        if(response.getStatus() == 400 ){
            String error = response.readEntity(String.class);
            System.out.println(error);
        }
        if(response.getStatus() == 200) {
            EmpleadoDTO empleadoDTO1 =  response.readEntity(EmpleadoDTO.class);
            System.out.println(empleadoDTO1.getNombre());
            System.out.println(empleadoDTO1.getPrimerApellido());
        }




    }
}
