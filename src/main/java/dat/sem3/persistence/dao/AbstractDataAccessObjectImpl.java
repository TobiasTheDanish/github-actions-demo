package dat.sem3.persistence.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public abstract class AbstractDataAccessObjectImpl<T> implements DataAccessObject<T> {
    protected final EntityManagerFactory emf;
    public AbstractDataAccessObjectImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public  <K> T getById(Class<T> clazz, K id) {
        T entity = null;
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            entity = em.find(clazz, id);
            em.getTransaction().commit();
        }
        return entity;
    }

    @Override
    public T create(T entity) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }

        return entity;
    }

    @Override
    public T update(T entity) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        }

        return entity;
    }

    @Override
    public void delete(T entity) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }
    }
}
