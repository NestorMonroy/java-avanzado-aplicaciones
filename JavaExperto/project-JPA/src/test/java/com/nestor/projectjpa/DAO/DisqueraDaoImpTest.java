package com.nestor.projectjpa.DAO;

import com.nestor.projectjpa.entity.Disquera;
import junit.framework.TestCase;

import java.time.LocalDateTime;

public class DisqueraDaoImpTest extends TestCase {
    private final DisqueraDao disqueraDao = new DisqueraDaoImp();

    public void testGuardar() {

        Disquera disquera = new Disquera();
        disquera.setDescripcion("MegaForce");
        disquera.setFechaCreacion(LocalDateTime.now());
        disquera.setEstatus(true);
        this.disqueraDao.guardar(disquera);

    }

    public void testActualizar() {
    }

    public void testEliminiar() {
    }

    public void testConsulta() {
    }

    public void testTestGuardar() {
    }

    public void testTestActualizar() {
    }

    public void testTestEliminiar() {
    }

    public void testTestConsulta() {
    }

    public void testConsultarById() {
    }
}