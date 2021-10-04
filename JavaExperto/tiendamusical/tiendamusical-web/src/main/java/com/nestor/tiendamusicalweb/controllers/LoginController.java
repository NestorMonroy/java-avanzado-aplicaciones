package com.nestor.tiendamusicalweb.controllers;

import com.nestor.tiendamusicalentities.entities.Persona;
import com.nestor.tiendamusicalservices.service.LoginService;
import com.nestor.tiendamusicalweb.session.SessionBean;
import com.nestor.tiendamusicalweb.utils.CommonUtils;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.IOException;

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
    /**
     * Propiedad de la logica de negocio inyectada con JSF y Spring.
     */
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;

    @PostConstruct
    public void init() {
        System.out.println("Inicializando login...");
    }

    public void ingresar() {
        Persona personaConsultada = this.loginServiceImpl.consultarUsuarioLogin(this.usuario, this.password);
        if (personaConsultada != null) {
            try {
                this.sessionBean.setPersona(personaConsultada);
                CommonUtils.redireccionar("/pages/commons/dashboard.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
                CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "ERROR", "No se puede ingresar");
            }
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

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
