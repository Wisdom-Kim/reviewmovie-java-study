package repository;

import domain.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.NoArgsConstructor;
import util.JpaUtil;

import java.util.List;

@NoArgsConstructor
public class MovieRepository {

    private MovieRepository movieRepository;
    private static final EntityManagerFactory emf =  JpaUtil.getEntityManagerFactory();
    private static final EntityManager em = emf.createEntityManager();

    public void save(Movie review){
        
        em.persist(review);
    }

    public Movie findOne(Long id){
        
        return em.find(Movie.class,id);
    }
    public static List<Movie> findAll(){

        return em.createQuery("select m from Movie m ",Movie.class).getResultList();
    }
}
