package com.nestor.tiendamusicalservices.service;

import com.nestor.tiendamusicalentities.dto.ArtistaAlbumDTO;

import java.util.List;

/**
 * @author NestorMonroy
 * Interface que define los metodos de logica de negocio para la pantalla del home.
 */

public interface HomeService {

    /**
     * Método que permite consultar los albums con base al filtro que ingrese el cliente en el buscador de su home.
     *
     * @param filtro {@link String} texto ingresado por el cliente.
     * @return {@link List} lista de albums que coinciden con el texto ingresado.
     */
    List<ArtistaAlbumDTO> consultarAlbumsFiltro(String filtro);
}
