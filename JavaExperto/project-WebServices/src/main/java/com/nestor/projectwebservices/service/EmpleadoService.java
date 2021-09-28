package com.nestor.projectwebservices.service;

import com.nestor.projectwebservices.entity.Empleado;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoService {
    public Empleado consultarEmpleadoById(String numeroEmpleado) {
        List<Empleado> empleadosConsultados = this.consultarListaEmpleados();
        for (Empleado empleadoConsultado : empleadosConsultados) {
            if (empleadoConsultado.getNumeroEmpleado().equals(numeroEmpleado)) {
                return empleadoConsultado;
            }

        }
        return null;
    }

    /**
     * Metodo que similima la consulta de un empleado
     */

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

    public List<Empleado> consultarListaEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        Empleado empleado = new Empleado();
        empleado.setNumeroEmpleado("123456");
        empleado.setNombre("Nestor");
        empleado.setPrimerApellido("Monroy");
        empleado.setSegundoApellido("Valero");
        empleado.setFechaCreacion(LocalDateTime.now());
        empleado.setEdad(20);

        Empleado empleadoNuevo = new Empleado();
        empleadoNuevo.setNumeroEmpleado("1234560");
        empleadoNuevo.setNombre("Otro");
        empleadoNuevo.setPrimerApellido("Otro");
        empleadoNuevo.setSegundoApellido("Otro");
        empleadoNuevo.setFechaCreacion(LocalDateTime.now());
        empleadoNuevo.setEdad(20);

        empleados.add(empleado);
        empleados.add(empleadoNuevo);
        return empleados;

    }
}
