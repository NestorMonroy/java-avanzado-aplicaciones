package com.nestor.tiendamusicalweb.controllers;

import com.nestor.tiendamusicalentities.entities.CarritoAlbum;
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
     * /**
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

    /**
     * Método que permite eliminar un album del carrito del usuario.
     *
     * @param carritoAlbum {@link CarritoAlbum} objeto con el album a eliminar del carrito.
     */
    public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
        LOGGER.info("Eliminando album " + carritoAlbum.getAlbum().getNombre() + " del carrito");

        this.carritoServiceImpl.eliminarAlbumCarrito(carritoAlbum);
        this.sessionBean.getPersona().getCarrito().getCarritosAlbum().remove(carritoAlbum);
        this.calcularTotal();
    }

    /**
     * Método que permite actualizar la cantidad y los totales del album a comprar.
     *
     * @param carritoAlbum {@link CarritoAlbum} objeto que contiene el album a actualizar y su cantidad.
     */
    public void actualizarCantidadCarrito(CarritoAlbum carritoAlbum) {
        float totalCompra = this.carritoServiceImpl.actualizarAlbumCantidad(carritoAlbum, this.sessionBean.getPersona().getCarrito());

        this.sessionBean.setTotalCompra(totalCompra);
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
