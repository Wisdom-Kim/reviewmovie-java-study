package repository;

import domain.Likes;
import domain.Rating;
import domain.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.NoArgsConstructor;
import util.JpaUtil;

import java.util.List;

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

    public Likes findOne(int id){
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
}
