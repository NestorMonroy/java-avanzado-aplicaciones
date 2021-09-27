package com.nestor.projectjpa.DAO;

import com.nestor.projectjpa.entity.Disquera;
import com.nestor.projectjpa.entity.SubGenero;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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


    }

    @Override
    public void actualizar(SubGenero subGenero) {

    }

    @Override
    public void eliminiar(Long id) {

    }


    @Override
    public SubGenero consultarById(Long id) {
        return null;
    }
}
