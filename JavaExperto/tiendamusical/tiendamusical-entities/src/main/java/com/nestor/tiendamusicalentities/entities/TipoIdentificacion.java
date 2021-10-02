package com.nestor.tiendamusicalentities.entities;

import javax.persistence.*;
/**
 * @author Nestor
 * Clase que contiene entidades de tipos de identificacion de una persona o usuario.
 */
@Entity
@Table(name = "tipoidentificacion")
public class TipoIdentificacion extends Common{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoIdentificacion")
    private Long idTipoIdentificacion;

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    public Long getIdTipoIdentificacion() {
        return idTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(Long idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
