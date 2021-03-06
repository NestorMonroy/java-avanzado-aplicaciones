package com.nestor.tiendamusicaldata.dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import com.nestor.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.nestor.tiendamusicalentities.entities.Artista;
/**
 * @author NestorMonroy
 * Interfaz que representa el DAO para el CRUD hacia la tabla de Artistas.
 */
public interface ArtistaDAO extends PagingAndSortingRepository<Artista, Long> {
    @Query("SELECT new com.nestor.tiendamusicalentities.dto.ArtistaAlbumDTO(a, ar) "
            + "FROM Album a "
            + "INNER JOIN a.artista ar "
            + "INNER JOIN ar.subGenero sg "
            + "INNER JOIN sg.genero g "
            + "WHERE ar.nombre LIKE %:filtro% "
            + "OR g.descripcion LIKE %:filtro% "
            + "OR sg.descripcion LIKE %:filtro% "
            + "OR a.nombre LIKE %:filtro% "
            + "ORDER BY ar.nombre")
    List<ArtistaAlbumDTO> consultarArtistasAlbumsPorFiltro(@Param("filtro") String filtro);
}
