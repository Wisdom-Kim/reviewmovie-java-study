package service;

import domain.Movie;
import domain.Rating;
import domain.Review;
import domain.User;
import dto.LikesDTO;
import dto.ReviewDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MovieRepository;
import repository.ReviewRepository;
import util.JpaUtil;

import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReviewServiceTest {

    private final LikesService likesService = new LikesService();
    private final UserService userService = new UserService();
    private final ReviewService reviewService = new ReviewService();
    private final MovieService movieService = new MovieService();
    private final MovieRepository movieRepository = MovieRepository.getInstance();
    private EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();


    @Test
    void getReview(){
        ReviewDTO reviewDTO = reviewService.getReview(1);
        assertEquals(reviewDTO.getReviewId(),1);
    }
    @Test
    void insertReview() {
        User user = userService.getUser("cocoa389", "1234").toEntity();
        Movie movie = movieService.getMovie(102).toEntity();
        Rating rating = Rating.builder().ratingScore(5).build();
        Review review = Review.builder()
                .reviewContent("Great movie!")
                .reviewDate(new Date())
                .user(user)
                .movie(movie)
                .rating(rating)
                .build();
        reviewService.insertReview(ReviewDTO.fromEntity(review));

        LikesDTO likesDTO = LikesDTO.builder()
                .userId(user.getUserId())
                .reviewId(review.getReviewId())
                .build();

        // When
        likesService.insertLikes(likesDTO);

        // Then
        LikesDTO retrievedLikes = likesService.getLikes(likesDTO.getLikesId());
        assertNotNull(retrievedLikes);
        assertEquals(likesDTO.getUserId(), retrievedLikes.getUserId());



    }

    @Test
    void updateReview() {
    }

    @Test
    void getReviewListByMovieId() {
    }
}