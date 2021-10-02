package com.nestor.tiendamusicalweb.controllers;

import com.nestor.tiendamusicalweb.utils.CommonUtils;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class LoginController {

    private String usuario;
    private String password;

    @PostConstruct
    public void init(){
        System.out.println("Inicializando login...");
    }

    public void ingresar(){
        if (this.usuario.equals("nestor") && this.password.equals("12345")){
            CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_INFO,"OK", "Bienvenido");
        }else {
            CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_FATAL,"ERROR", "Algo es incorrecto");
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
}
