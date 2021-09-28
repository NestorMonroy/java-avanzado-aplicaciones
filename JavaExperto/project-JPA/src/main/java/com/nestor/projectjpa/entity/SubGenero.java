package com.nestor.projectjpa.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
    * Con .LAZY Solo realiza la consulta la información de la tabla indicada
    * */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idGenero") //Campo con la relacion Genero
    @Cascade(CascadeType.REMOVE)
    //Con PERSIST si queremos guardar información de las dos tablas
    //Con MERGE se actualiza
    //Con REMOVE se elimina
    //Con ALL si siempre se hace CASCADA EN cualquier topo de transaction
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
