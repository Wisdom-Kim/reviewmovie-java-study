package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import domain.Movie;

public class MovieRepository {
    private EntityManager em;

    public MovieRepository(EntityManager em) {
        this.em = em;
    }

    public List<Movie> searchMoviesByTitle(String title) {
        String jpql = "SELECT m FROM Movie m WHERE m.movieTitle LIKE :title";
        TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }

    public List<Movie> findMoviesByRatingDesc() {
        String jpql = "SELECT m FROM Movie m "
                    + "LEFT JOIN m.reviewList r "
                    + "LEFT JOIN r.ratingList rat "
                    + "GROUP BY m "
                    + "ORDER BY AVG(rat.ratingScore) DESC";

        TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
        return query.getResultList();
    }
}