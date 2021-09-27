package com.nestor.projectjpa.DAO;

import com.nestor.projectjpa.entity.Disquera;

import java.util.List;

public interface DisqueraDao {
    void guardar(Disquera disquera);

    void actualizar(Disquera disquera);

    void eliminiar(Long id);

    List<Disquera> consulta();

    Disquera consultarById(Long id);

    /**
     * Método que permite consultar con JQPL la disquera a partir de una descripción.
     *
     * @param descripcion {@link String} descripción de la disquera.
     * @return {@link Disquera} la disquera consultada.
     */
    Disquera consultarByDescripcionJPQL(String descripcion);

    
}
