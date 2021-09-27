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
        Disquera disqueraConsultada = this.disqueraDao.consultarById(9L);
        disqueraConsultada.setDescripcion("Disquera Actualizada");
        this.disqueraDao.actualizar(disqueraConsultada);
    }

    public void testEliminiar() {
        Long id = 10L;
        this.disqueraDao.eliminiar(id);

    }

    public void testConsulta() {
    }

    public void testConsultarById() {
        Disquera disquera = this.disqueraDao.consultarById(9L);
        System.out.println("La disquera es :" + disquera.getDescripcion());
    }


}