package com.nestor.projectjpa.DAO;

import com.nestor.projectjpa.entity.Disquera;

import javax.persistence.*;
import java.util.List;

/**
 * The type Disquera dao imp.
 */
public class DisqueraDaoImp implements DisqueraDao {

    // EntityManagerFactory: Permite indicar como se llama la unidad de persistencia del archivo xml mapeo
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistenceNestor");


    @Override
    public void guardar(Disquera disquera) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(disquera); //persist guarda
            et.commit(); //Asegura los resultados en la base de datos
        } catch (Exception e) {
            if (et != null) {
                et.rollback(); //Reinicia **
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Disquera disquera) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(disquera); //merge actualiza
            et.commit(); //Asegura los resultados en la base de datos
        } catch (Exception e) {
            if (et != null) {
                et.rollback(); //Reinicia **
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminiar(Disquera disquera) {

    }

    @Override
    public List<Disquera> consulta() {
        return null;
    }

    @Override
    public Disquera consultarById(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        em.find(Disquera.class, id);

        Disquera disqueraConsultado = em.find(Disquera.class, id);
        if (disqueraConsultado == null) {
            throw new EntityNotFoundException("La disquera con id " + id + " no se encontro");
        }

        return disqueraConsultado;
    }
}
