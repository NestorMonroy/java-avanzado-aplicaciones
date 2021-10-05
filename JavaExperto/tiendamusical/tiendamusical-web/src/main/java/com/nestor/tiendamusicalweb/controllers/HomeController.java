package com.nestor.tiendamusicalweb.controllers;

import com.nestor.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.nestor.tiendamusicalservices.service.HomeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * @author NestorMonroy
 * Clase que contrala el flujo de informacion para la pantalla de home de cualquier tipo de usuario.
 */
@ManagedBean
@ViewScoped
public class HomeController {

    /**
     * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o en un archivo externo.
     */
    private static final Logger LOGGER = LogManager.getLogger(HomeController.class);


    /**
     * Texto ingresado por el cliente en el buscador.
     */
    private String filtro;
    /**
     * Lista obtenida a partir del filtro ingresado en el buscador.
     */
    private List<ArtistaAlbumDTO> artistasAlbumDTO;
    /**
     * Se inyecta el objeto de spring con jsf para obtener los metodos de logica de negocio del home.
     */
    @ManagedProperty("#{homeServiceImpl}")
    private HomeService homeServiceImpl;

    /**
     * Inicializando pantalla.
     */
    @PostConstruct
    public void init() {
        LOGGER.info("INFO");
        LOGGER.warn("WARN");
        LOGGER.error("ERROR");
        LOGGER.fatal("FATAL");
    }

    /**
     * Método que permite obtener los albums de los artistas encontrados en la base de datos
     * con respecto al filtro ingresado por el cliente.
     */
    public void consultarAlbumsArtistasPorFiltro() {
        this.artistasAlbumDTO = this.homeServiceImpl.consultarAlbumsFiltro(this.filtro);

        if (this.artistasAlbumDTO != null) {
            this.artistasAlbumDTO.forEach(artistaAlbumDTO -> {
                //System.out.println("Artista: " + artistaAlbumDTO.getArtista().getNombre());
                LOGGER.info("Artista: " + artistaAlbumDTO.getArtista().getNombre());
            });
        }
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public List<ArtistaAlbumDTO> getArtistasAlbumDTO() {
        return artistasAlbumDTO;
    }

    public void setArtistasAlbumDTO(List<ArtistaAlbumDTO> artistasAlbumDTO) {
        this.artistasAlbumDTO = artistasAlbumDTO;
    }

    public HomeService getHomeServiceImpl() {
        return homeServiceImpl;
    }

    public void setHomeServiceImpl(HomeService homeServiceImpl) {
        this.homeServiceImpl = homeServiceImpl;
    }
}
