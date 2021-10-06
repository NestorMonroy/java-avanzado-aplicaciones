package com.nestor.tiendamusicalweb.controllers;

import com.nestor.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.nestor.tiendamusicalentities.entities.CarritoAlbum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
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


    }

    public int getCantidadAlbumSeleccionada() {
        return cantidadAlbumSeleccionada;
    }

    public void setCantidadAlbumSeleccionada(int cantidadAlbumSeleccionada) {
        this.cantidadAlbumSeleccionada = cantidadAlbumSeleccionada;
    }
}
