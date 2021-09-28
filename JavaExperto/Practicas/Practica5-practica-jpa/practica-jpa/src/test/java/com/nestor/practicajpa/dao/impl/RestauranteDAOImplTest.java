package com.nestor.practicajpa.dao.impl;

import com.nestor.practicajpa.dao.RestauranteDAO;
import com.nestor.practicajpa.entity.Restaurante;
import com.nestor.practicajpa.entity.TipoRestaurante;
import junit.framework.TestCase;

import java.time.LocalDateTime;
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

    public void testActualizar() {

        Restaurante restauranteConsultado = this.restauranteDAO.consutarById(10L);
        restauranteConsultado.setNombre("Restaurante Actualizado");
        restauranteConsultado.setFechaModificacion(LocalDateTime.now());

        this.restauranteDAO.actualizar(restauranteConsultado);
    }

    public void testGuardar() {

        Restaurante restaurante = new Restaurante();
        restaurante.setNombre("Otro Nombre");
        restaurante.setSlogan("Otro Slogan");
        restaurante.setFechaCreacion(LocalDateTime.now());
        restaurante.setEstatus(true);

        TipoRestaurante tipoRestaurante = new TipoRestaurante();
        tipoRestaurante.setIdTipoRestaurante(1L);

        restaurante.setTipoRestaurante(tipoRestaurante);

        this.restauranteDAO.guardar(restaurante);
    }


    public void testEliminar() {
        this.restauranteDAO.eliminar(14L);
    }
}