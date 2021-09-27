package com.nestor.projectjpa.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author NestorMonroy.
 * Clase que representa una entidad de subgeneros.
 */

@Entity
@Table(name = "subgenero")
public class SubGenero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSubGenero")
    private Long idSubGenero;

    @Column(name = "descripcion")
    private String descripcion;


    /*
    * Cuando no se especifica en ManyToOne, en automático hace una consulta fetch
    * Por defecto consulta EAGER que obtiene toda la información de las tablas relacionadas
    *
    * */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idGenero") //Campo con la relacion Genero
    private Genero genero;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaModificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "estatus")
    private boolean estatus;


    public Long getIdSubGenero() {
        return idSubGenero;
    }

    public void setIdSubGenero(Long idSubGenero) {
        this.idSubGenero = idSubGenero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
}
