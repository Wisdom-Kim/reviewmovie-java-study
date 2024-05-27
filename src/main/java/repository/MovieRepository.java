package repository;

import java.util.List;

import domain.Movie;
import dto.MovieDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import util.JpaUtil;

public class MovieRepository {
    private static MovieRepository instance;
    private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    private MovieRepository() {
    }

    public static synchronized MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;
    }

    public Movie findById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Movie.class, id);
        } finally {
            em.close();
        }
    }

    public List<Movie> searchMoviesByTitle(String title) {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT m FROM Movie m WHERE m.movieTitle LIKE :title";
            TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
            query.setParameter("title", "%" + title + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Movie> findMoviesByRatingDesc() {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT m FROM Movie m "
                    + "LEFT JOIN m.reviewList r "
                    + "LEFT JOIN r.rating rat "
                    + "GROUP BY m "
                    + "ORDER BY AVG(rat.ratingScore) DESC";
            TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public double getAverageRating(MovieDTO movieDTO) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Double> query = em.createQuery(
                    "SELECT AVG(r.ratingScore) FROM Rating r WHERE r.review.movie.movieId = :movieId", Double.class
            );
            query.setParameter("movieId", movieDTO.getMovieId());
            Double averageRating = query.getSingleResult();
            return (averageRating != null) ? averageRating : 0.0;
        } finally {
            em.close();
        }
    }
}
