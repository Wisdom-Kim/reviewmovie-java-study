package repository;

import domain.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import util.JpaUtil;

import java.util.List;

public class ReviewRepository {

    private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    public void save(Review review) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(review);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Review findById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Review.class, id);
        } finally {
            em.close();
        }
    }

    public List<Review> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("select r from Review r", Review.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void update(Review review) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(review);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Review review = em.find(Review.class, id);
            if (review != null) {
                em.remove(review);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
