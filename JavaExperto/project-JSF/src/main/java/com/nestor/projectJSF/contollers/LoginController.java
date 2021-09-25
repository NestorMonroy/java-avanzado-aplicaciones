package com.nestor.projectJSF.contollers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * @author Nestor Monroy
 */


@ManagedBean(name = "loginController") //Generar controladores Si no tiene ManagedBean, maneja en au
//automático el nombre de clase en minúsculas
public class LoginController {

    private String usuario;
    private String password;


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

    public void ingresar() {
        System.out.println("Usuario: " + usuario);
        if (usuario.equals("nestor") & password.equals("12345")) {
            this.redireccionar("principal.xhtml");
        } else {
            FacesContext.getCurrentInstance().addMessage("formLogin:txtUsuario", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario/Password Incorrecto", ""));
        }
    }

    private void redireccionar(String pagina){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(pagina);
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage("formLogin:txtUsuario", new FacesMessage(FacesMessage.SEVERITY_FATAL, "La pagina no existe", ""));
            e.printStackTrace();
        }
    }
}
