package service;

import domain.Movie;
import domain.Review;
import domain.User;
import dto.ReviewDTO;
import org.junit.jupiter.api.Test;
import repository.MovieRepository;
import repository.ReviewRepository;

import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReviewServiceTest {


    private final ReviewService reviewService = new ReviewService();
    private final MovieService movieService = new MovieService();
    private final MovieRepository movieRepository = MovieRepository.getInstance();
    @Test
    void insertReview() {
        User user = UserService.getUser("cocoa389","1234").toEntity();
        Movie movie = movieService.getMovie(102).toEntity();

        ReviewDTO reviewDTO = ReviewDTO.builder()
                .reviewContent("너무 어려운 영화")
                .reviewDate(new Date())
                .userId(user.getUserId())
                .userName(user.getUserName())
                .movieId(movie.getMovieId())
                .movieTitle(movie.getMovieTitle())
                .ratingScore(3)
                .likesList(Collections.emptyList())
                .build();

        Review review = reviewDTO.toEntity();
        review.setUser(user);
        review.setMovie(movie);

        // Mock the save behavior

        // When
        reviewService.insertReview(reviewDTO);

        // Then
        ReviewDTO reviewDTO1 = reviewService.getReview(1);
        assertEquals(reviewDTO.getReviewId(), reviewDTO1.getReviewId());

    }

    @Test
    void updateReview() {
    }

    @Test
    void getReviewListByMovieId() {
    }
}