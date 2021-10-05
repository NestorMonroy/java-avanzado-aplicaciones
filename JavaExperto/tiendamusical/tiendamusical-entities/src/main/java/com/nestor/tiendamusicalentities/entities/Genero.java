package com.nestor.tiendamusicalentities.entities;

import javax.persistence.*;

/**
 * @author NestorMonroy.
 * Clase que representa entidades de generos de musica.
 */
@Entity
@Table(name = "genero")
public class Genero extends Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGenero")
    private Long idGenero;

    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
