package repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		    String jpql = "SELECT DISTINCT m "
		            + "FROM Movie m "
		            + "LEFT JOIN m.reviewList r "
		            + "LEFT JOIN r.rating rat "
		            + "ORDER BY (SELECT AVG(r2.rating.ratingScore) FROM Review r2 WHERE r2.movie = m) DESC";
		    TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
		    List<Movie> movies = query.getResultList();
		    return movies;
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
