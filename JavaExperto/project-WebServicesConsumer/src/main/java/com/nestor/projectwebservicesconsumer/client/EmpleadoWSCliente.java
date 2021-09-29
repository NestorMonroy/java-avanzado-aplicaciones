package com.nestor.projectwebservicesconsumer.client;

import com.nestor.projectwebservicesconsumer.dto.EmpleadoDTO;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Clase cliente que permite consumir los WebService de Empleados
 */

public class EmpleadoWSCliente {

    public static void main(String[] args) {

        // ::::::::: GET:::::::::
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
        }


    }
}
