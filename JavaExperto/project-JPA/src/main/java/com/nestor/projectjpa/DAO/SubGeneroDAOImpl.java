package com.nestor.projectjpa.DAO;

import com.nestor.projectjpa.entity.Disquera;
import com.nestor.projectjpa.entity.SubGenero;

import javax.persistence.*;
import java.util.List;

public class SubGeneroDAOImpl implements SubGeneroDAO {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistenceNestor");

    @Override
    public List<SubGenero> consultar() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        TypedQuery<SubGenero> querySubGenero = (TypedQuery<SubGenero>) em.createQuery("FROM SubGenero ORDER BY descripcion");
        return querySubGenero.getResultList();
    }


    @Override
    public void guardar(SubGenero subGenero) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(subGenero);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(SubGenero subGenero) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(subGenero);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

    @Override
    public void eliminiar(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        SubGenero subGeneroConsultado = em.find(SubGenero.class, id);
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.remove(subGeneroConsultado);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    @Override
    public SubGenero consultarById(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        return em.find(SubGenero.class, id);
    }
}
