package service;

import domain.Likes;
import domain.Movie;
import domain.Rating;
import domain.Review;
import domain.User;
import dto.LikesDTO;
import dto.RatingDTO;
import dto.ReviewDTO;
import org.junit.jupiter.api.Test;
import repository.LikesRepository;
import repository.MovieRepository;
import repository.RatingRepository;
import repository.ReviewRepository;
import repository.UserRepository;
import util.JpaUtil;

import jakarta.persistence.EntityManagerFactory;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LikesServiceTest {

    private final LikesService likesService = new LikesService();
    private final UserService userService = new UserService();
    private final ReviewService reviewService = new ReviewService();
    private final MovieService movieService = new MovieService();
    private final RatingService ratingService = new RatingService();
    private final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    @Test
    void insertLikes() {
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

        LikesDTO likesDTO = LikesDTO.builder()
                .userId(user.getUserId())
                .reviewId(reviewDTO.getReviewId())
                .build();

        // When
        likesService.insertLikes(likesDTO);

        // Then
        LikesDTO retrievedLikes = likesService.getLikes(likesDTO.getLikesId());
        assertNotNull(retrievedLikes);
        assertEquals(likesDTO.getUserId(), retrievedLikes.getUserId());
        assertEquals(likesDTO.getReviewId(), retrievedLikes.getReviewId());
    }

    @Test
    void countLikesByReviewId() {
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

        LikesDTO likesDTO1 = LikesDTO.builder()
                .userId(user.getUserId())
                .reviewId(reviewDTO.getReviewId())
                .build();
        likesService.insertLikes(likesDTO1);

        LikesDTO likesDTO2 = LikesDTO.builder()
                .userId(user.getUserId())
                .reviewId(reviewDTO.getReviewId())
                .build();
        likesService.insertLikes(likesDTO2);

        int count = likesService.countLikesByReviewId(reviewDTO.getReviewId());
        assertEquals(2, count);
    }
}
