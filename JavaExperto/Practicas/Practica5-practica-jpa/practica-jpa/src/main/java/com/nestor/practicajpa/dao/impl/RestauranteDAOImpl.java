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

    }

    @Override
    public void actualizar(Restaurante restaurante) {

    }

    @Override
    public void eliminar(Long id) {

    }


}
