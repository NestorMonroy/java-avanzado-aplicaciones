package com.nestor.projectjpa.DAO;

import com.nestor.projectjpa.entity.Disquera;

import java.util.List;

public interface DisqueraDao {
    void guardar(Disquera disquera);

    void actualizar(Disquera disquera);

    void eliminiar(Long id);

    List<Disquera> consulta();

    Disquera consultarById(Long id);
}
