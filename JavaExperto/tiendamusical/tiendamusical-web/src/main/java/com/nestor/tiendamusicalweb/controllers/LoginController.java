package com.nestor.tiendamusicalweb.controllers;

import com.nestor.tiendamusicalentities.entities.Persona;
import com.nestor.tiendamusicalservices.service.LoginService;
import com.nestor.tiendamusicalweb.utils.CommonUtils;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * @author NestorMonroy
 * Controlador que se encarga del flujo de la pantalla de login.xhtml.
 */
@ManagedBean
@ViewScoped
public class LoginController {

    private String usuario;
    private String password;
    /**
     * Propiedad de la logica de negocio inyectada con JSF y Spring.
     */
    @ManagedProperty("#{loginServiceImpl}")
    private LoginService loginServiceImpl;

    @PostConstruct
    public void init() {
        System.out.println("Inicializando login...");
    }

    public void ingresar() {
        Persona personaConsultada = this.loginServiceImpl.consultarUsuarioLogin(this.usuario, this.password);
        if (personaConsultada != null) {
            CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_INFO, "OK", "Bienvenido");
        } else {
            CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "ERROR", "Algo es incorrecto");
        }
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginService getLoginServiceImpl() {
        return loginServiceImpl;
    }

    public void setLoginServiceImpl(LoginService loginServiceImpl) {
        this.loginServiceImpl = loginServiceImpl;
    }
}
