package repository;

import domain.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import util.JpaUtil;

import java.util.List;

public class ReviewRepository {

    private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
    private static ReviewRepository reviewRepository;

    private ReviewRepository() {
    }

    public static ReviewRepository getInstance() {
        if (reviewRepository == null) {
            reviewRepository = new ReviewRepository();
        }
        return reviewRepository;
    }

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

    public Review findOne(int id) {
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
            return em.createQuery("SELECT r FROM Review r", Review.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void delete(Review review) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(review) ? review : em.merge(review));
            em.getTransaction().commit();
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


}
