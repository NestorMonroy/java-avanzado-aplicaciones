package com.nestor.tiendamusicalweb.session;

import com.nestor.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.nestor.tiendamusicalentities.entities.Persona;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author NestorMonroy
 * Clase que mantendra la informacion en la sesion del usuario.
 */
@ManagedBean
@SessionScoped
public class SessionBean {
    /**
     * Objeto persona que se mantendrá en la session.
     */
    private Persona persona;

    /**
     * Objeto que contendrá la información del detalle del album seleccionado por el cliente.
     */
    private ArtistaAlbumDTO artistaAlbumDTO;

    @PostConstruct
    public void init(){
        System.out.println("Creando sesión...");
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public ArtistaAlbumDTO getArtistaAlbumDTO() {
        return artistaAlbumDTO;
    }

    public void setArtistaAlbumDTO(ArtistaAlbumDTO artistaAlbumDTO) {
        this.artistaAlbumDTO = artistaAlbumDTO;
    }
}
