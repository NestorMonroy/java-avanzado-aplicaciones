package com.nestor.projectjpa.DAO;

import com.nestor.projectjpa.entity.Disquera;
import junit.framework.TestCase;

import java.time.LocalDateTime;
import java.util.List;

public class DisqueraDAOImpTest extends TestCase {
    private final DisqueraDAO disqueraDAO = new DisqueraDAOImp();

    public void testGuardar() {

        Disquera disquera = new Disquera();
        disquera.setDescripcion("MegaForce");
        disquera.setFechaCreacion(LocalDateTime.now());
        disquera.setEstatus(true);
        this.disqueraDAO.guardar(disquera);

    }

    public void testActualizar() {
        Disquera disqueraConsultada = this.disqueraDAO.consultarById(9L);
        disqueraConsultada.setDescripcion("Disquera Actualizada");
        this.disqueraDAO.actualizar(disqueraConsultada);
    }

    public void testEliminiar() {
        Long id = 10L;
        this.disqueraDAO.eliminiar(id);

    }

    public void testConsulta() {
        List<Disquera> disquerasConsultadas = this.disqueraDAO.consulta();
        assertTrue(disquerasConsultadas.size() > 0); //Si contiene registros
        disquerasConsultadas.forEach(disquera -> {
            System.out.println("Disquera: " + disquera.getDescripcion());
        });
    }

    public void testConsultarById() {
        Disquera disquera = this.disqueraDAO.consultarById(9L);
        assertNotNull(disquera); //Asegurar que no llegue null el objeto
        System.out.println("La disquera es :" + disquera.getDescripcion());
    }


    public void testConsultarByDescripcionJPQL() {
        Disquera disqueraConsultada = this.disqueraDAO.consultarByDescripcionJPQL("Disquera Actualizada");
        assertNotNull(disqueraConsultada); //Asegurar que no llegue null el objeto

        System.out.println("La disquera es  :" + disqueraConsultada);
    }


    public void testConsultarByDescripcionNative() {
        Disquera disqueraConsultada = this.disqueraDAO.consultarByDescripcionNative("Disquera Actualizada");

        assertNotNull(disqueraConsultada);

        System.out.println("Disquera by descripción: " + disqueraConsultada);
    }
}