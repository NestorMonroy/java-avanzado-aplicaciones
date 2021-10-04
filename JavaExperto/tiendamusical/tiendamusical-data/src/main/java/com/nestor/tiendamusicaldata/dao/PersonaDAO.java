package com.nestor.tiendamusicaldata.dao;

import com.nestor.tiendamusicalentities.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Clase DAO/Repository que realiza el CRUD con SpringJPA para la tabla de persona.
 * @author NestorMonroy
 */
public interface PersonaDAO extends PagingAndSortingRepository<Persona, Long> {

    /**
     * Método que permite consultar el usuario que trata de ingresar a session.
     *
     * @param usuario {@link String} usuario capturado por la persona.
     * @param password {@link String} contraseña capturada por la persona.
     * @return {@link Persona} objeto con la persona encontrada.
     */
    @Query("select p from Persona p where p.usuario = ?1 AND p.password = ?2")
    Persona findByUsuarioAndPassword(String usuario,String password);

}
