package com.nestor.tiendamusicalweb.session;

import com.nestor.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.nestor.tiendamusicalentities.entities.Persona;
import com.paypal.http.HttpResponse;
import com.paypal.orders.Order;

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

    /**
     * Total generado de la compra en session.
     */
    private float totalCompra;

    /**
     * Orden generada por paypal.
     */
    private HttpResponse<Order> order;

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

    public float getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(float totalCompra) {
        this.totalCompra = totalCompra;
    }

    public void setOrder(HttpResponse<Order> response) {
        this.order = response;
    }

    public HttpResponse<Order> getOrder() {
        return order;
    }
}
