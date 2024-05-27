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

	 private MovieRepository() {}

	 public static synchronized MovieRepository getInstance() {
	     if (instance == null) {
	         instance = new MovieRepository();
	     }
	     return instance;
	 }

	 public Movie findById(int id, EntityManager em) {
	     return em.find(Movie.class, id);
	 }

	 public List<Movie> searchMoviesByTitle(String title, EntityManager em) {
	     String jpql = "SELECT m FROM Movie m WHERE m.movieTitle LIKE :title";
	     TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
	     query.setParameter("title", "%" + title + "%");
	     return query.getResultList();
	 }

	 public List<Movie> findMoviesByRatingDesc(EntityManager em) {
	     String jpql = "SELECT m FROM Movie m "
	             + "LEFT JOIN FETCH m.reviewList r "
	             + "LEFT JOIN FETCH r.rating rat "
	             + "GROUP BY m "
	             + "ORDER BY AVG(rat.ratingScore) DESC";
	     TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
	     return query.getResultList();
	 }

	 public double getAverageRating(MovieDTO movieDTO, EntityManager em) {
	     TypedQuery<Double> query = em.createQuery(
	             "SELECT AVG(r.ratingScore) FROM Rating r WHERE r.review.movie.movieId = :movieId", Double.class
	     );
	     query.setParameter("movieId", movieDTO.getMovieId());
	     Double averageRating = query.getSingleResult();
	     return (averageRating != null) ? averageRating : 0.0;
	 }
}
