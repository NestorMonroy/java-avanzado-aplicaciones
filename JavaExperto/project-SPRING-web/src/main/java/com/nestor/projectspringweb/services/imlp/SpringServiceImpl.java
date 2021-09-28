package com.nestor.projectspringweb.services.imlp;

import com.nestor.projectspringweb.dao.EmpleadoDAO;
import com.nestor.projectspringweb.services.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SpringServiceImpl implements SpringService {

    @Autowired // Puede poner inyectar objeto de una clase SPRING a otra clase con SPRING
    private EmpleadoDAO empleadoDAOImpl;

    @Override
    public String mostrarNombreEmpresa() {
        return "Anotaciones con SPRING Y JSF";
    }

    @Override
    public String mostrarNombreEmpleado() {
        return this.empleadoDAOImpl.consultarNombreEmpleado();
    }
}
