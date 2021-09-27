package com.nestor.projectjpa.DAO;

import com.nestor.projectjpa.entity.SubGenero;

import java.util.List;

/**
 * The interface Sub genero dao.
 *
 * @author Nestor Monroy Interface DAO que realiza el CRUD con JPA para la tabla de subgenero.
 */
public interface SubGeneroDAO {
    /**
     * Método que permite guardar un subgénero.
     * @param subGenero  {@link SubGenero} objeto a guardar.
     */
    void guardar(SubGenero subGenero);

    /**
     * Método que permite actualizar un subgénero.
     * @param subGenero {@link SubGenero} objeto a actualizar.
     */
    void actualizar(SubGenero subGenero);

    /**
     * Método que permite eliminar un subgénero por su identificador.
     * @param id {@link Long} identificador del subgénero a eliminar.
     */
    void eliminiar(Long id);

    /**
     * Método que permite consultar la lista de subgéneros.
     * @return {@link List} lista de subgéneros consultados.
     */
    List<SubGenero> consultar();

    /**
     * Método que permite consultar un SubGenero a partir de su identificador.
     * @param id {@link Long} identificador del subgénero a consultar.
     * @return {@link SubGenero} un objeto subgénero consultado.
     */
    SubGenero consultarById(Long id);


}
