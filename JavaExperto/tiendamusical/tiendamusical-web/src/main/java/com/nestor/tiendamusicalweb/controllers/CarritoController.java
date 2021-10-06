package com.nestor.tiendamusicalweb.controllers;

import com.nestor.tiendamusicalservices.service.CarritoService;
import com.nestor.tiendamusicalweb.session.SessionBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * @author NestorMonroy
 * Clase que se encarga de controlar el flujo de la pantalla del carrito de compras.
 */
@ManagedBean
@ViewScoped
public class CarritoController {
    /**
     * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo.
     */
    private static final Logger LOGGER = LogManager.getLogger(CarritoController.class);
    /**
     * Objeto que contiene la información en sesión del usuario.
     */
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;
    /**
     /**
     * Objeto que realiza la lógica de negocio para el carrito de compras.
     */
    @ManagedProperty("#{carritoServiceImpl}")
    private CarritoService carritoServiceImpl;
    /**
     * Inicializa la información de la pantalla del carrito.
     */
    @PostConstruct
    public void init() {
        this.calcularTotal();
    }

    /**
     * Método que permite calcular el total de la compra con respecto a los albums en el carrito.
     */
    public void calcularTotal() {
        LOGGER.info("Calculando total...");
        float total = this.carritoServiceImpl.calcularTotal(this.sessionBean.getPersona().getCarrito());

        this.sessionBean.setTotalCompra(total);
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public CarritoService getCarritoServiceImpl() {
        return carritoServiceImpl;
    }

    public void setCarritoServiceImpl(CarritoService carritoServiceImpl) {
        this.carritoServiceImpl = carritoServiceImpl;
    }
}
