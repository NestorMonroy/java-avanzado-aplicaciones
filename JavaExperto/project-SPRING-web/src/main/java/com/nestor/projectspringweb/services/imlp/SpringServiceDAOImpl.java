package com.nestor.projectspringweb.services.imlp;

import com.nestor.projectspringweb.services.SpringService;
import org.springframework.stereotype.Service;


@Service
public class SpringServiceDAOImpl implements SpringService {

    @Override
    public String mostrarNombreEmpresa() {
        return "Anotaciones con SPRING Y JSF";
    }
}
