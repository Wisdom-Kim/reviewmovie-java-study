package repository;

import domain.Rating;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import util.JpaUtil;

import java.util.List;

public class RatingRepository {

    //엔터티와 서비스 계층 사이 계층
    //저장소 하나는 계속 쓰여야하므로 싱글톤으로 관리

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
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(rating);
            em.getTransaction().commit();}
        catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
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
