package com.nestor.practicajpa.dao;

import com.nestor.practicajpa.entity.Restaurante;

import java.util.List;

/**
 * @author NestorMonroy
 */
public interface RestauranteDAO {

    List<Restaurante> consultar();

    Restaurante consutarById(Long id);

    void guardar(Restaurante restaurante);

    void actualizar(Restaurante restaurante);

    void eliminar(Long id);


}
