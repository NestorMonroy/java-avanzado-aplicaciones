package com.nestor.projectspringweb.controllers;


import com.nestor.projectspringweb.services.SpringService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * @author NestorMonroy
 * Controlador de ejemplo para demostrar la integracion de Spring con JSF.
 */


@ManagedBean // Clase considera como Controlador de JSF
@ViewScoped //EL alcance es a nivel de la pantalla
public class SpringJSFController {

    //Creando objeto SIN SPRING
    //SpringService springService = new SpringServiceDAOImpl();

    private String nombreEmpresa;
    private String nombreEmpleado;

    @ManagedProperty("#{springServiceImpl}")
    //JSF, Cuando se utiliza con Spring se puede inyectar el objeto de spring
    private SpringService springServiceImpl;

    @PostConstruct // Cuando se carga por primera vez se ejecuta el método e inicializa
    public void init() {
        String nombre = this.nombreEmpresa = this.springServiceImpl.mostrarNombreEmpresa();
        System.out.println(nombre);
        this.nombreEmpresa = nombre;

        String nombreEmpleado = this.springServiceImpl.mostrarNombreEmpleado();
        System.out.println("El nombre empleado es : " + nombreEmpleado);
        this.nombreEmpleado = nombreEmpleado;
    }

    public SpringService getSpringServiceImpl() {
        return springServiceImpl;
    }

    public void setSpringServiceImpl(SpringService springServiceImpl) {
        this.springServiceImpl = springServiceImpl;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }
}
