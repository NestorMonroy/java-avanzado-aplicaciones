package com.nestor.tiendamusicalweb.controllers;

import com.nestor.tiendamusicalentities.dto.ArtistaAlbumDTO;
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
 * @author DevPredator
 * Clase que controla el flujo de la pantalla de detalle.xhtml
 */
@ManagedBean
@ViewScoped
public class DetalleController {

    /**
     * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo.
     */
    private static final Logger LOGGER = LogManager.getLogger(DetalleController.class);
    /**
     * Cantidad del producto seleccionado.
     */
    private int cantidadAlbumSeleccionada;
    /**
     * Objeto que contiene los métodos de la logica de negocio del carrito.
     */
    @ManagedProperty("#{carritoServiceImpl}")
    private CarritoService carritoServiceImpl;

    /**
     * Objeto que contiene la información del usuario en sesion.
     */
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;

    /**
     * Inicializa la pantalla del detalle.
     */
    @PostConstruct
    public void init() {
        this.cantidadAlbumSeleccionada = 1;
    }

    /**
     * Método que permite agregar el album seleccionado por el usuario al carrito de compras.
     * @param artistaAlbumDTO {@link ArtistaAlbumDTO} objeto con el album seleccionado.
     */
    public void agregarAlbumCarrito(ArtistaAlbumDTO artistaAlbumDTO) {
        LOGGER.info("Agregando album al carrito de compras..." + ", Cantidad: " + this.cantidadAlbumSeleccionada);

        CarritoAlbum carritosAlbumAgregado = this.carritoServiceImpl.guardarAlbumsCarrito(artistaAlbumDTO, this.sessionBean.getPersona().getCarrito(), cantidadAlbumSeleccionada);

        this.sessionBean.getPersona().getCarrito().getCarritosAlbum().add(carritosAlbumAgregado);

    }

    public int getCantidadAlbumSeleccionada() {
        return cantidadAlbumSeleccionada;
    }

    public void setCantidadAlbumSeleccionada(int cantidadAlbumSeleccionada) {
        this.cantidadAlbumSeleccionada = cantidadAlbumSeleccionada;
    }

    public CarritoService getCarritoServiceImpl() {
        return carritoServiceImpl;
    }

    public void setCarritoServiceImpl(CarritoService carritoServiceImpl) {
        this.carritoServiceImpl = carritoServiceImpl;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
