package repository;

import domain.Rating;
import domain.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import util.JpaUtil;
import java.util.List;

//repository 싱글톤 처리
public class RatingRepository {

    private static RatingRepository ratingRepository;
    private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

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
            em.persist(rating);
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
            return em.createQuery("select r from Rating r", Rating.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void delete(Rating rating) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(rating) ? rating : em.merge(rating)); //em이 어떻게든 rating을 관리하는 상태로 만들기
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
}
