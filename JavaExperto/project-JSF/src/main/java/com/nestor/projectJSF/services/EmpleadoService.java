package com.nestor.projectJSF.services;

import com.nestor.projectJSF.entity.Empleado;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Clase que permite realizar la logica de negocios para empleados
 */
public class EmpleadoService {

    /**
     * Metodo que permite consultar la lista de empleados de empresas TI
     * @return {@link Empleado} lista de empleados.
     */
    public List<Empleado> consultarEmpleados() {

        List<Empleado> empleados = new ArrayList<Empleado>();

        Empleado empleadoIBM = new Empleado();
        Empleado empleadoMicrosoft = new Empleado();
        Empleado empleadoApple = new Empleado();

        empleadoIBM.setNombre("Nestor");
        empleadoIBM.setPrimerApellido("Monroy");
        empleadoIBM.setSegundoApellido("Valero");
        empleadoIBM.setPuesto("Dev Java");
        empleadoIBM.setEstatus(true);

        empleadoMicrosoft.setNombre("Joel");
        empleadoMicrosoft.setPrimerApellido("Hernandez");
        empleadoMicrosoft.setSegundoApellido("Contreras");
        empleadoMicrosoft.setPuesto("CEO");
        empleadoMicrosoft.setEstatus(true);

        empleadoApple.setNombre("Ejemplo1");
        empleadoApple.setPrimerApellido("Monroy1");
        empleadoApple.setSegundoApellido("Valero1");
        empleadoApple.setPuesto("Dev Java");
        empleadoApple.setEstatus(true);

        empleados.add(empleadoIBM);
        empleados.add(empleadoMicrosoft);
        empleados.add(empleadoApple);

        return empleados;

    }
}
