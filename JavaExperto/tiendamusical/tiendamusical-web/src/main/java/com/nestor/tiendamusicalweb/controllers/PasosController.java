package com.nestor.tiendamusicalweb.controllers;

import com.nestor.tiendamusicalweb.session.SessionBean;
import com.nestor.tiendamusicalweb.utils.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.IOException;

/**
 * @author DevPredator
 * Controlador que maneja el flujo de cambio de pasos en el proceso de compra de productos.
 */
@ManagedBean
@ViewScoped
public class PasosController {
    /**
     * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo.
     */
    private static final Logger LOGGER = LogManager.getLogger(PasosController.class);

    /**
     * Objeto que contiene la información en sesión del usuario.
     */
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;

    @PostConstruct
    public void init() {
        LOGGER.info("Ingresando a PasosController.");
    }

    /**
     * Método que permite redireccionar al siguiente paso del proceso de compra de productos.
     * @param url {@link String} url con la pantalla siguiente a mostrar.
     * @param paso {@link Integer} numero del paso siguiente de la compra.
     */
    public void cambiarPaso(String url, int paso) {
        try {
            this.sessionBean.setPaso(paso);
            CommonUtils.redireccionar(url);
        } catch (IOException e) {
            CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "UPS!",
                    "Hubo un problema al tratar de ingresar al siguiente paso de la compra, favor de intentarlo más tarde.");
            e.printStackTrace();
        }
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
