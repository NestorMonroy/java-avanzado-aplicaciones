package com.nestor.tiendamusicalweb.session;

import com.nestor.tiendamusicalentities.entities.Persona;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author NestorMonroy
 * Clase que mantendra la informacion en la sesion del usuario.
 */
@ManagedBean
@SessionScoped
public class SessionBean {
    /**
     * Objeto persona que se mantendra en la sesion.
     */
    private Persona persona;

    @PostConstruct
    public void init(){
        System.out.println("Creando sesion...");
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
