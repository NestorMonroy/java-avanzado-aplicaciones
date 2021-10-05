package com.nestor.tiendamusicalweb.session;


import com.nestor.tiendamusicalweb.utils.CommonUtils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * @author NestorMonroy
 * Clase que permite cerrar la sesion del usuario y redireccionar a la pantalla del login.
 */
@ManagedBean
@ViewScoped
public class SessionClosed {
    /**
     * Método que permite cerrar la sesion del usuario.
     */
    public void cerrarSesion() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession(); //Cierra la sesion
            CommonUtils.redireccionar("/login.xhtml");
        } catch (IOException e) {
            CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "¡Ups!", "Hubo un problema al tratar de regresar al login, favor de intentar más tarde.");
            e.printStackTrace();
        }
    }
}
