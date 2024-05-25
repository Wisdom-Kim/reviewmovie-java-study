package repository;

import java.util.List;

import domain.Movie;
import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import lombok.NoArgsConstructor;
import util.JpaUtil;
import java.util.List;

public class MovieRepository {
    private EntityManager em;

    public MovieRepository(EntityManager em) {
        this.em = em;
    }

    public List<Movie> searchMoviesByTitle(String title) {
        String jpql = "SELECT m FROM Movie m WHERE m.title LIKE :title";
        TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }

    public List<Movie> findAll() {
        String jpql = "SELECT m FROM Movie m";
        TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
        return query.getResultList();

    }

    
}
