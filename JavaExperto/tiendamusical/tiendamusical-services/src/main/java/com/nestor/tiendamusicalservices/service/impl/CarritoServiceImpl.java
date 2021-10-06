package com.nestor.tiendamusicalservices.service.impl;

import com.nestor.tiendamusicaldata.dao.CarritoAlbumDAO;
import com.nestor.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.nestor.tiendamusicalentities.entities.Carrito;
import com.nestor.tiendamusicalentities.entities.CarritoAlbum;
import com.nestor.tiendamusicalservices.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author NestorMonroy
 * Clase que implementa los metodos de la logica de negocio de Carrito Service para el carrito de compras.
 */
@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private CarritoAlbumDAO carritoAlbumDAO;

    @Override
    public CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito, int cantidadAlbumSeleccionada) {

        CarritoAlbum carritoAlbum = new CarritoAlbum();
        carritoAlbum.setAlbum(artistaAlbumDTO.getAlbum());
        carritoAlbum.setCarrito(carrito);
        carritoAlbum.setCantidad(cantidadAlbumSeleccionada);
        carritoAlbum.setEstatus("PENDIENTE");

        this.carritoAlbumDAO.save(carritoAlbum);

        return carritoAlbum;
    }

    @Override
    public float calcularTotal(Carrito carrito) {
        float total = 0.0F;

        //Se realiza el cálculo del total de la compra.
        for (CarritoAlbum carritoAlbum : carrito.getCarritosAlbum()) {
            total += (carritoAlbum.getAlbum().getValor() * carritoAlbum.getCantidad());
        }

        return total;
    }

    @Override
    public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
        this.carritoAlbumDAO.delete(carritoAlbum);
    }
}
