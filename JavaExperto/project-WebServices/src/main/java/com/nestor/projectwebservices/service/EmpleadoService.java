package com.nestor.projectwebservices.service;

import com.nestor.projectwebservices.entity.Empleado;

import java.time.LocalDateTime;

public class EmpleadoService {
    public Empleado consultarEmpleadoById(Long id) {
        return null;
    }

    /**
     * Metodo que similima la consulta de un empleado
     * */

    public Empleado consultarEmpleado() {
        Empleado empleado = new Empleado();
        empleado.setNumeroEmpleado("123456");
        empleado.setNombre("Nestor");
        empleado.setPrimerApellido("Monroy");
        empleado.setSegundoApellido("Valero");
        empleado.setFechaCreacion(LocalDateTime.now());
        empleado.setEdad(20);

        return empleado;

    }

}
