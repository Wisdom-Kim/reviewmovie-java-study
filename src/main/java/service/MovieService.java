package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Movie;
import dto.MovieDTO;
import repository.MovieRepository;

public class MovieService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_config");
    private EntityManager em = emf.createEntityManager();
    private MovieRepository movieRepository;

    public MovieService() {
        movieRepository = new MovieRepository(em);
    }

    public List<MovieDTO> searchMoviesByTitle(String movieTitle) {
        List<Movie> movies = movieRepository.searchMoviesByTitle(movieTitle);
        List<MovieDTO> movieDTOs = new ArrayList<>();
        
        for (Movie movie : movies) {
            MovieDTO movieDTO = MovieDTO.fromEntity(movie);
            movieDTOs.add(movieDTO);
        }
        
        return movieDTOs;
    }

    public List<MovieDTO> getMoviesByRatingDesc() {
        List<Movie> movies = movieRepository.findMoviesByRatingDesc();
        List<MovieDTO> movieDTOs = new ArrayList<>();
        
        for (Movie movie : movies) {
            MovieDTO movieDTO = MovieDTO.fromEntity(movie);
            movieDTOs.add(movieDTO);
        }
        
        return movieDTOs;
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