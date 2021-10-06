package com.nestor.tiendamusicalentities.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author NestorMonroy.
 * Clase que representa la cantida de entidades de albums en el carrito de la persona.
 */
@Entity
@Table(name = "carrito_album")
public class CarritoAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarritoAlbum;

    @ManyToOne
    @JoinColumn(name = "idCarrito")
    private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "idAlbum")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "idFactura")
    private Factura factura;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "estatus")
    private String estatus;

    @Column(name = "fechaCompra")
    private LocalDateTime fechaCompra;

    public Long getIdCarritoAlbum() {
        return idCarritoAlbum;
    }

    public void setIdCarritoAlbum(Long idCarritoAlbum) {
        this.idCarritoAlbum = idCarritoAlbum;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
