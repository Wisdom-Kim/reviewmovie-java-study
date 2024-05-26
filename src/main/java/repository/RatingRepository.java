package repository;

import domain.Rating;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import util.JpaUtil;

import java.util.List;

public class RatingRepository {

    private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
    private static RatingRepository ratingRepository;

    private RatingRepository() {
    }

    public static RatingRepository getInstance() {
        if (ratingRepository == null) {
            ratingRepository = new RatingRepository();
        }
        return ratingRepository;
    }

    public void save(Rating rating) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (rating.getRatingId() == 0) {
                em.persist(rating);
            } else {
                em.merge(rating);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Rating findOne(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Rating.class, id);
        } finally {
            em.close();
        }
    }

    public List<Rating> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT r FROM Rating r", Rating.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void delete(Rating rating) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(rating) ? rating : em.merge(rating));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
