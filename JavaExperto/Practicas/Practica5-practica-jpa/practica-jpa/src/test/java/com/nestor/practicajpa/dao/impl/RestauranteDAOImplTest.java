package com.nestor.practicajpa.dao.impl;

import com.nestor.practicajpa.dao.RestauranteDAO;
import com.nestor.practicajpa.entity.Restaurante;
import junit.framework.TestCase;

import java.util.List;

public class RestauranteDAOImplTest extends TestCase {
    private final RestauranteDAO restauranteDAO = new RestauranteDAOImpl();

    public void testConsultar() {
        List<Restaurante> restaurantesConsultados = this.restauranteDAO.consultar();
        assertTrue(restaurantesConsultados.size() > 0);
        restaurantesConsultados.forEach(restaurante -> {
            System.out.println("El restaurante es :" + restaurante.getNombre());
        });
    }

    public void testConsutarById() {
        Restaurante restaurante = this.restauranteDAO.consutarById(10L);
        assertNotNull(restaurante);
        System.out.println("El restaurante es :" + restaurante.getNombre());
    }
}