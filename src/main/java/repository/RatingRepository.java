package repository;

import domain.Movie;
import domain.Rating;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import util.JpaUtil;

import java.util.List;

public class RatingRepository {

    private RatingRepository ratingRepository;
    private static final EntityManagerFactory emf =  JpaUtil.getEntityManagerFactory();
    private static final EntityManager em = emf.createEntityManager();

    public void save(Rating rating){
        //리뷰 저장
        em.persist(rating);
    }

    public Rating findOne(Long id){
        //리뷰
        return em.find(Rating.class,id);
    }
    public static List<Movie> findAll(){

        return em.createQuery("select r from Review r",Movie.class).getResultList();
    }
}
