package repository;

import domain.Likes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import util.JpaUtil;

import java.util.List;

public class LikesRepository {

    private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
    private static LikesRepository likesRepository;

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
            return em.createQuery("SELECT l FROM Likes l", Likes.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void delete(Likes likes) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(likes) ? likes : em.merge(likes));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public int countLikesByReviewId(int reviewId) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(l) FROM Likes l WHERE l.review.reviewId = :reviewId", Long.class
            );
            query.setParameter("reviewId", reviewId);
            Long countLikes = query.getSingleResult();
            return countLikes.intValue();
        } finally {
            em.close();
        }
    }
}
