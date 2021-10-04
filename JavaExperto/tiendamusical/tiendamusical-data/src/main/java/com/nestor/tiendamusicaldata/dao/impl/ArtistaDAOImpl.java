package com.nestor.tiendamusicaldata.dao.impl;

import com.nestor.tiendamusicaldata.common.CommonRepository;
import com.nestor.tiendamusicaldata.dao.ArtistaDAO;
import com.nestor.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.nestor.tiendamusicalentities.entities.Artista;

import java.util.List;


/**
 * @author NestorMonroy
 * Clase que implementa el CRUD Generico para realizar las transacciones a la tabla de artista.
 */
public class ArtistaDAOImpl extends CommonRepository<Artista, ArtistaDAO> {

    public List<ArtistaAlbumDTO> consultarArtistaAlbumPorFiltro(String filtro) {
        return this.repository.consultarArtistasAlbumsPorFiltro(filtro);
    }
}
