package com.nestor.projectjpa.DAO;

import com.nestor.projectjpa.entity.SubGenero;
import junit.framework.TestCase;

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
}