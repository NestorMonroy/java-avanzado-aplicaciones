package com.nestor.practicajpa.dao.impl;

import com.nestor.practicajpa.dao.RestauranteDAO;
import com.nestor.practicajpa.entity.Restaurante;

import javax.persistence.*;
import java.util.List;

/**
 * @author NestorMonroy
 */
public class RestauranteDAOImpl implements RestauranteDAO {

    private final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("persistenceNestor");

    @Override
    public List<Restaurante> consultar() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        TypedQuery<Restaurante> queryRestaurante = (TypedQuery<Restaurante>) em.createQuery("FROM Restaurante  ORDER BY nombre");
        return queryRestaurante.getResultList();
    }

    @Override
    public Restaurante consutarById(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        //em.find(Restaurante.class, id);
        Restaurante restauranteConsultado = em.find(Restaurante.class, id);
        if (restauranteConsultado == null) {
            throw new EntityNotFoundException("El restaurante con " + id + "no se encontro.");
        }
        return restauranteConsultado;
    }

    @Override
    public void guardar(Restaurante restaurante) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(restaurante);
            et.commit();
        } catch (Exception e) {
            if (e != null) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Restaurante restaurante) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(restaurante);
            et.commit();
        } catch (Exception e) {
            if (e != null) {
                et.rollback();
            }
        } finally {
            em.close();
        }

    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        Restaurante restauranteConsultado = em.find(Restaurante.class, id);
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.remove(restauranteConsultado);
            et.commit();
        } catch (Exception e) {
            if (e != null) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }


}
