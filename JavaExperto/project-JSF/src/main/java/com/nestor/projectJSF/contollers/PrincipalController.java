package com.nestor.projectJSF.contollers;

import com.nestor.projectJSF.entity.Empleado;
import com.nestor.projectJSF.services.EmpleadoService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Clase controller que se encarga de procesar la informacion para la pantalla principal.xhtml.
 */
@ManagedBean //Controlador de JSF
@ViewScoped // Mantener la informacion en la vista, hasta movernos a otra pantalla
public class PrincipalController {
    /**
     * Lista de empleados para la tabla.
     */
    private List<Empleado> empleados;
    /**
     * Servicio con los métodos que realizan la logica de negocio de empleados..
     */
    private final EmpleadoService empleadoService = new EmpleadoService();

    /**
     * Método que se encarga de inicializar la información de la pantalla principal.
     */

    @PostConstruct //Solo se ejecuta cuando está en la pantalla
    public void init() {
        this.consultarEmpleados();
    }


    public void consultarEmpleados() {
        this.empleados = this.empleadoService.consultarEmpleados();

    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}
