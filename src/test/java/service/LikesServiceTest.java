package service;

import domain.Movie;
import domain.Rating;
import domain.Review;
import domain.User;
import dto.LikesDTO;
import dto.RatingDTO;
import dto.ReviewDTO;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;
import util.JpaUtil;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LikesServiceTest {


    private final LikesService likesService = new LikesService();

    private final UserService userService = new UserService();
    private final ReviewService reviewService = new ReviewService();
    private final MovieService movieService = new MovieService();
    private EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    @Test
    void insertLikes() {
        User user = userService.getUser("cocoa389", "1234").toEntity();
        Movie movie = movieService.getMovie(102).toEntity(); // 인셉션
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
        assertEquals(likesDTO.getReviewId(), retrievedLikes.getReviewId());
    }

    @Test
    void getLikes() {
        LikesDTO likesDTO = LikesDTO.builder()
                .userId(1)
                .reviewId(1)//아직 리뷰가 없어서 못한다
                .build();
        likesService.insertLikes(likesDTO);

        LikesDTO retrievedLikes = likesService.getLikes(1);

        assertNotNull(retrievedLikes);
        assertEquals(retrievedLikes.getUserId(), 1, "user id가 1일것");
    }

    @Test
    void getAllLikes() {
    }

    @Test
    void deleteLikes() {
    }
}