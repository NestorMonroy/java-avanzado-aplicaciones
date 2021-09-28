package com.nestor.projectspringweb.controllers;


import com.nestor.projectspringweb.services.SpringService;
import com.nestor.projectspringweb.services.imlp.SpringServiceDAOImpl;

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

    @ManagedProperty("#{springServiceDAOImpl}")
    //JSF, Cuando se utiliza con Spring se puede inyectar el objeto de spring
    private SpringService springServiceImpl;

    @PostConstruct // Cuando se carga por primera vez se ejecuta el método e inicializa
    public void init() {
        String nombre = this.nombreEmpresa = this.springServiceImpl.mostrarNombreEmpresa();
        System.out.println(nombre);
        this.nombreEmpresa = nombre;
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
}
