package repository;

import java.util.List;

import domain.Likes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import util.JpaUtil;

//repository 싱글톤 처리
public class LikesRepository {

    private static final EntityManagerFactory emf =  JpaUtil.getEntityManagerFactory();
    private static LikesRepository likesRepository;

    //싱글톤으로 만들기
    private LikesRepository() {
    }

    public static LikesRepository getInstance() {
        if (likesRepository == null) {
            likesRepository = new LikesRepository();
        }
        return likesRepository;
    }

    public void save(Likes likes) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(likes);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Likes findOne(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Likes.class, id);
        } finally {
            em.close();
        }
    }

    public List<Likes> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("select l from Likes l",Likes.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void delete(Likes likes) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(likes) ? likes : em.merge(likes)); //em이 어떻게든 likes를 관리하게 만들기
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public int countLikesByReviewId(int reviewId) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Integer> query = em.createQuery("SELECT COUNT(l) FROM Likes l WHERE l.review.reviewId = :reviewId", Integer.class);
            query.setParameter("reviewId", reviewId);
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }
}
