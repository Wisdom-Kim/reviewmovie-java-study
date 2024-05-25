package service;

import domain.Movie;
import dto.MovieDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    private final MovieService movieService = new MovieService();
    @Test
    void searchMoviesByTitle() {
        String targetTitle="인셉션";
        List<MovieDTO> movies = movieService.searchMoviesByTitle(targetTitle);
        assertNotNull(movies,"인셉션이라는 영화는 존재해야함");
    }

    @Test
    void getMoviesByRatingDesc() {

    }

    @Test
    void getAverageRating() {
    }

    @Test
    void close() {
    }
}