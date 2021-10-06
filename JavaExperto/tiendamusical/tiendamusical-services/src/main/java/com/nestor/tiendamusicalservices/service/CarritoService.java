package com.nestor.tiendamusicalservices.service;

import com.nestor.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.nestor.tiendamusicalentities.entities.Carrito;
import com.nestor.tiendamusicalentities.entities.CarritoAlbum;

/**
 * @author NestorMonroy
 * Interface que define los metodos de logica de negocio para el carrito de compras.
 */
public interface CarritoService {
    /**
     * Método que permite guardar los albums a comprar en el carrito de compras.
     * @param artistaAlbumDTO {@link ArtistaAlbumDTO} objeto con la información del album en el carrito.
     * @param carrito {@link Carrito} objeto con la información del carrito del usuario.
     * @param cantidadAlbumSeleccionada {@link Integer} cantidad seleccionada del album por el usuario.
     */
    CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito, int cantidadAlbumSeleccionada);

    /**
     * Método que permite calcular el total de la compra.
     * @param carrito {@link Carrito} objeto con la información del carrito a calcular.
     * @return {@link Float} total calculado.
     */
    float calcularTotal(Carrito carrito);
}
