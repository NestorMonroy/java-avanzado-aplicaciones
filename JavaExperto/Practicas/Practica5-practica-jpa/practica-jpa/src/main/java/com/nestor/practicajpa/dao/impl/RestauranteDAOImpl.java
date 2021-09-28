package com.nestor.practicajpa.dao.impl;

import com.nestor.practicajpa.dao.RestauranteDAO;
import com.nestor.practicajpa.entity.Restaurante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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
        return null;
    }

    @Override
    public void guardar(Restaurante restaurante) {

    }

    @Override
    public void actualizar(Restaurante restaurante) {

    }

    @Override
    public void eliminar(Long id) {

    }


}
