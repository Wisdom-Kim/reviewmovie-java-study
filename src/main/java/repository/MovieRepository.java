package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import domain.Movie;
import dto.MovieDTO;
import util.JpaUtil;

public class MovieRepository {

    private static MovieRepository movieRepository;
    private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    private MovieRepository() {
    }

    public static MovieRepository getInstance() {
        if (movieRepository == null) {
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }

    public Movie findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Movie.class, id);
    }

    public List<Movie> searchMoviesByTitle(String title) {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT m FROM Movie m WHERE m.movieTitle LIKE :title"; //Movie 객체의 필드명으로 수정
        TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }

    public List<Movie> findMoviesByRatingDesc() {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT m FROM Movie m "
                    + "LEFT JOIN m.reviewList r "
                    + "LEFT JOIN r.ratingList rat "
                    + "GROUP BY m "
                    + "ORDER BY AVG(rat.ratingScore) DESC";

        TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
        return query.getResultList();
    }
    
    public double getAverageRating(MovieDTO movieDTO) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Double> query = em.createQuery(
                "SELECT AVG(r.ratingScore) FROM Rating r WHERE r.review.movie.movieId = :movieId", Double.class
            );
            query.setParameter("movieId", movieDTO.getMovieId());
            Double averageRating = query.getSingleResult();
            return (averageRating != null) ? averageRating : 0.0; //해당하는 영화가 없다면 일단 0으로 반환
        } finally {
            em.close();
        }
    }
}
