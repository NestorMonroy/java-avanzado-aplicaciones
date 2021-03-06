package com.nestor.tiendamusicalweb.controllers;

import com.nestor.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.nestor.tiendamusicalservices.service.HomeService;
import com.nestor.tiendamusicalweb.session.SessionBean;
import com.nestor.tiendamusicalweb.utils.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
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
     * Objeto que almacena informacion en sesion.
     */
    @ManagedProperty("#{sessionBean}")
    private SessionBean sessionBean;

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

    /**
     * Método que permite ver el detalle del album seleccionado por el cliente.
     *
     * @param artistaAlbumDTO {@link ArtistaAlbumDTO} objeto con el album seleccionado.
     */
    public void verDetalleAlbum(ArtistaAlbumDTO artistaAlbumDTO) {
        this.sessionBean.setArtistaAlbumDTO(artistaAlbumDTO);
        try {
            CommonUtils.redireccionar("/pages/cliente/detalle.xhtml");
        } catch (IOException e) {
            CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "¡UPS!", "Hubo un error de formato en la página a ingresar. "
                    + "Favor de contactar con soporte.");
            e.printStackTrace();
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

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
