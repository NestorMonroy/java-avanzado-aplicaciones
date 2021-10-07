package com.nestor.tiendamusicaldata.dao;

import com.nestor.tiendamusicalentities.entities.CarritoAlbum;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author NestorMonroy
 * Interface que implementa los metodos genericos para el CRUD con SPRING JPA hacia la tabla de carrito_album
 */
public interface CarritoAlbumDAO extends PagingAndSortingRepository<CarritoAlbum, Long> {
}
