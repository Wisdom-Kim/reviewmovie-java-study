package repository;

import domain.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.NoArgsConstructor;
import util.JpaUtil;

import java.util.List;

@NoArgsConstructor
public class ReviewRepository {

    private  ReviewRepository reviewRepository;
    private static final EntityManagerFactory emf =  JpaUtil.getEntityManagerFactory();
    private static final EntityManager em = emf.createEntityManager();

    public void save(Review review){
        //리뷰 저장
        em.persist(review);
        em.close();
    }

    public Review findOne(Long id){
        //리뷰
        Review review = em.find(Review.class,id);
        em.close();
        return review;
    }
    public static List<Review> findAll(){

        List<Review> reviewList =  em.createQuery("select r from Review r",Review.class).getResultList();
        em.close();
        return reviewList;
    }
}
