package ir.mrmoein.demo2.repository.impl;

import ir.mrmoein.demo2.repository.BaseRepo;
import ir.mrmoein.demo2.util.EmFactor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public abstract class BaseRepoImpl<T> implements BaseRepo<T> {

    private final EntityManagerFactory emf = EmFactor.getEmf();

    @Override
    public void save(T user) throws RuntimeException {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(user);
            em.flush();
            if (transaction.getRollbackOnly()) {
                transaction.rollback();
            } else {
                transaction.commit();
            }
        } catch (Exception exception) {
            throw new RuntimeException(" this exception for save methode in repository " + exception.getMessage());
        }
    }

    @Override
    public void remove(T user) throws RuntimeException {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(user);
            if (transaction.getRollbackOnly()) {
                transaction.rollback();
            } else {
                transaction.commit();
            }
        } catch (Exception exception) {
            throw new RuntimeException(" this exception for remove methode in repository " + exception.getMessage());
        }
    }

    @Override
    public <V> T findByID(V value) throws RuntimeException {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(customize(), value);
        } catch (Exception exception) {
            throw new RuntimeException(" this exception for findByID methode in repository " + exception.getMessage());
        }
    }

    public abstract Class<T> customize();
}
