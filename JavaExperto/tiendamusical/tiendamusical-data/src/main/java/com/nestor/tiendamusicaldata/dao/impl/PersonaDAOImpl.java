package com.nestor.tiendamusicaldata.dao.impl;

import com.nestor.tiendamusicaldata.common.CommonRepository;
import com.nestor.tiendamusicaldata.dao.PersonaDAO;
import com.nestor.tiendamusicalentities.entities.Persona;

/**
 * @author NestorMonroy
 * Clase que implementa el CRUD Generico y las funciones de la interface de PersonaRepository.
 */
public class PersonaDAOImpl extends CommonRepository<Persona, PersonaDAO> {
    /**
     * Método permite consultar una persona por su usuario y contraseña.
     *
     * @param usuario  {@link String} usuario capturado por la persona.
     * @param password {@link String} contraseña capturada por la persona.
     * @return {@link Persona} persona encontrada.
     */
    public Persona findUsuarioAndPassword(String usuario, String password) {
        return this.repository.findByUsuarioAndPassword(usuario, password);
    }
}
