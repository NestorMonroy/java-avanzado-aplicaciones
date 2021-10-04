package com.nestor.tiendamusicalservices.service.impl;

import com.nestor.tiendamusicaldata.dao.ArtistaDAO;
import com.nestor.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.nestor.tiendamusicalservices.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author NestorMonroy
 * Clase que implementa los metodos de logica de negocio de la interface de LoginService.
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private ArtistaDAO artistaDAOImpl;

    @Override
    public List<ArtistaAlbumDTO> consultarAlbumsFiltro(String filtro) {
        return this.artistaDAOImpl.consultarArtistasAlbumsPorFiltro(filtro);
    }
}
