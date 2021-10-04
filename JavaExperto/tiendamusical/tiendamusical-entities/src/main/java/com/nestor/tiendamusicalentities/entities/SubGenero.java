package com.nestor.tiendamusicalentities.entities;

import javax.persistence.*;

/**
 * @author NestorMonroy.
 * Clase que representa entidades de SubGenero de musica.
 */
@Entity
@Table(name = "subgenero")
public class SubGenero extends Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSubGenero")
    private Long idSubGenero;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idGenero")
    private Genero genero;

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
}
