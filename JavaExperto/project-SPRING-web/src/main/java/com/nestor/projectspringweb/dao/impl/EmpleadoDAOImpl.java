package com.nestor.projectspringweb.dao.impl;

import com.nestor.projectspringweb.dao.EmpleadoDAO;
import org.springframework.stereotype.Repository;


@Repository //Todas las clases son interpretadas como clase JAVA son implementadas como DAO // INYECCIÓN SINGLETON
public class EmpleadoDAOImpl implements EmpleadoDAO {

    @Override
    public String consultarNombreEmpleado() {
        return "Nestor Monroy";
    }
}
