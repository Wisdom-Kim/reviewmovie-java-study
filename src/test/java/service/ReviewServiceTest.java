package service;

import domain.Movie;
import domain.User;
import dto.RatingDTO;
import dto.ReviewDTO;
import org.junit.jupiter.api.Test;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReviewServiceTest {

    private final UserService userService = new UserService();
    private final ReviewService reviewService = ReviewService.getInstance();
    private final MovieService movieService = new MovieService();

    @Test
    void insertReview() {
        User user = userService.getUser("cocoa389", "1234").toEntity();
//        Movie movie = movieService.getMovie(102).toEntity();
        RatingDTO ratingDTO = RatingDTO.builder().ratingScore(4).build();

        ReviewDTO reviewDTO = ReviewDTO.builder()
                .reviewContent("2트")
                .reviewDate(new Date())
                .userId(user.getUserId())
                .movieId(3)
                .build();

        reviewService.insertReview(reviewDTO, ratingDTO);
//
//        ReviewDTO retrievedReview = reviewService.getReview(2);
//        assertNotNull(retrievedReview);
//        assertEquals(reviewDTO.getReviewContent(), retrievedReview.getReviewContent());
    }

    @Test
    void deleteReview() {
        User user = userService.getUser("cocoa389", "1234").toEntity();
        Movie movie = movieService.getMovie(102).toEntity();
        RatingDTO ratingDTO = RatingDTO.builder().ratingScore(5).build();

        ReviewDTO reviewDTO = ReviewDTO.builder()
                .reviewContent("Great movie!")
                .reviewDate(new Date())
                .userId(user.getUserId())
                .movieId(movie.getMovieId())
                .ratingScore(ratingDTO.getRatingScore())
                .build();

        reviewService.insertReview(reviewDTO, ratingDTO);

        reviewService.deleteReview(reviewDTO.getReviewId());

        Exception exception = assertThrows(NullPointerException.class, () -> {
            reviewService.getReview(reviewDTO.getReviewId());
        });

        String expectedMessage = "Review not found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getReview() {
        User user = userService.getUser("cocoa389", "1234").toEntity();
        Movie movie = movieService.getMovie(102).toEntity();
        RatingDTO ratingDTO = RatingDTO.builder().ratingScore(5).build();

        ReviewDTO reviewDTO = ReviewDTO.builder()
                .reviewContent("Amazing!")
                .reviewDate(new Date())
                .userId(user.getUserId())
                .movieId(movie.getMovieId())
                .ratingScore(ratingDTO.getRatingScore())
                .build();

        reviewService.insertReview(reviewDTO, ratingDTO);

        ReviewDTO retrievedReview = reviewService.getReview(reviewDTO.getReviewId());
        assertNotNull(retrievedReview);
        assertEquals("Amazing!", retrievedReview.getReviewContent());
    }
}
