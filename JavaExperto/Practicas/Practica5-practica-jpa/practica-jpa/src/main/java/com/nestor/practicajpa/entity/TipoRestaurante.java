package com.nestor.practicajpa.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author NestorMonroy
 */
@Entity
@Table(name = "tipo_restaurante")
public class TipoRestaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoRestaurante;

    @Column(name = "descripcion", length = 500, nullable = false)
    private String descripcion;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaModificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "estatus", nullable = false)
    private boolean estatus;

    public Long getIdTipoRestaurante() {
        return idTipoRestaurante;
    }

    public void setIdTipoRestaurante(Long idTipoRestaurante) {
        this.idTipoRestaurante = idTipoRestaurante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
