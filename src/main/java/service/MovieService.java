package service;

import java.util.List;
import java.util.stream.Collectors;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import domain.Movie;
import dto.MovieDTO;
import jakarta.persistence.TypedQuery;
import repository.MovieRepository;
import util.JpaUtil;

public class MovieService {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
    private EntityManager em = emf.createEntityManager();
    private final MovieRepository movieRepository = MovieRepository.getInstance();


    public List<MovieDTO> searchMoviesByTitle(String movieTitle) {
        List<Movie> movies = movieRepository.searchMoviesByTitle(movieTitle);
        return movies.stream()
                .map(MovieDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> getMoviesByRatingDesc() {
        List<Movie> movies = movieRepository.findMoviesByRatingDesc();
        return movies.stream()
                .map(MovieDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public double getAverageRating(MovieDTO movieDTO) {
        return movieRepository.getAverageRating(movieDTO);
    }


    public MovieDTO getMovie(int movieId) {
        Movie movie = movieRepository.findById(movieId);
        return MovieDTO.fromEntity(movie);
    }

    public void close() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
