package com.nestor.tiendamusicalservices.service.impl;

import com.nestor.tiendamusicaldata.dao.PersonaDAO;
import com.nestor.tiendamusicalentities.entities.Persona;
import com.nestor.tiendamusicalservices.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author NestorMonroy
 * Clase que implementa las funciones para la logica de negocio para la pantalla de login.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private PersonaDAO personaDAOImpl;

    @Override
    public Persona consultarUsuarioLogin(String usuario, String password) {
        return this.personaDAOImpl.findByUsuarioAndPassword(usuario, password);
    }
}
