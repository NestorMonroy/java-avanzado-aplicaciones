package com.nestor.projectjpa.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The type Disquera.
 */
@Entity
@Table(name = "disquera")
public class Disquera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrementabble
    @Column(name = "idDisquera")
    private Long idDisquera;

    @Column(length = 100)
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private boolean estatus;

    /**
     * Gets id disquera.
     *
     * @return the id disquera
     */
    public Long getIdDisquera() {
        return idDisquera;
    }

    /**
     * Sets id disquera.
     *
     * @param idDisquera the id disquera
     */
    public void setIdDisquera(Long idDisquera) {
        this.idDisquera = idDisquera;
    }

    /**
     * Gets descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets descripcion.
     *
     * @param descripcion the descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Gets fecha creacion.
     *
     * @return the fecha creacion
     */
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Sets fecha creacion.
     *
     * @param fechaCreacion the fecha creacion
     */
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Gets fecha modificacion.
     *
     * @return the fecha modificacion
     */
    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    /**
     * Sets fecha modificación.
     *
     * @param fechaModificacion the fecha modificación
     */
    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    /**
     * Gets estatus.
     *
     * @return the estatus
     */
    public boolean getEstatus() {
        return estatus;
    }

    /**
     * Sets estatus.
     *
     * @param estatus the estatus
     */
    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
}
