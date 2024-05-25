package repository;

import domain.Review;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import lombok.NoArgsConstructor;
import util.JpaUtil;

import java.util.List;

@NoArgsConstructor
public class LikesRepository {

    private LikesRepository likesRepository;
    private static final EntityManagerFactory emf =  JpaUtil.getEntityManagerFactory();
    private static final EntityManager em = emf.createEntityManager();

    public void save(Review review){
        
        em.persist(review);
    }

    public Review findOne(Long id){
        
        return em.find(Review.class,id);
    }
    public static List<Review> findAll(){

        return em.createQuery("select r from Review r",Review.class).getResultList();
    }
}
