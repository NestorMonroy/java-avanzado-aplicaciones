package com.nestor.projectjpa.DAO;

import com.nestor.projectjpa.entity.Disquera;
import com.nestor.projectjpa.entity.Genero;
import com.nestor.projectjpa.entity.SubGenero;
import junit.framework.TestCase;

import java.time.LocalDateTime;
import java.util.List;

public class SubGeneroDAOImplTest extends TestCase {

    private final SubGeneroDAO subGeneroDAO = new SubGeneroDAOImpl();
    public void testConsultar() {

        List<SubGenero> subGenerosConsultados = this.subGeneroDAO.consultar();
        assertTrue(subGenerosConsultados.size() > 0 );
        subGenerosConsultados.forEach(subGenero -> {
            System.out.println("subGenero: " +subGenero.getDescripcion());
            System.out.println("Genero: " +subGenero.getGenero());
        });
    }

    public void testGuardar() {

        SubGenero subGenero = new SubGenero();
        subGenero.setDescripcion("Hard Core");
        subGenero.setFechaCreacion(LocalDateTime.now());
        subGenero.setEstatus(true);

        Genero genero = new Genero();
        genero.setDescripcion("Metal");
        genero.setFechaCreacion(LocalDateTime.now());
        genero.setEstatus(true);

        subGenero.setGenero(genero);

        this.subGeneroDAO.guardar(subGenero);

    }
}