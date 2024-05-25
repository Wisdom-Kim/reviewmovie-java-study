package service;

import domain.Movie;
import domain.Rating;
import domain.Review;
import domain.User;
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


    private final UserService userService = new UserService();
    private final ReviewService reviewService = new ReviewService();
    private final MovieService movieService = new MovieService();
    private final MovieRepository movieRepository = MovieRepository.getInstance();
    private EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    @BeforeEach
    void setUp() {
//        emf = Persistence.createEntityManagerFactory("your-persistence-unit");
//        EntityManager em = emf.createEntityManager();
    }

    @Test
    void insertReview() {
        User user = userService.getUser("cocoa389", "1234").toEntity();
        Movie movie = movieService.getMovie(102).toEntity();
        //레이팅 먼저 만들어야함
        Rating rating = Rating.builder().ratingScore(5).build();

        ReviewDTO reviewDTO = ReviewDTO.builder()
                .reviewId(3)
                .reviewContent("졸려요")
                .reviewDate(new Date())
                .userId(user.getUserId())
                .userName(user.getUserName())
                .movieId(movie.getMovieId())
                .movieTitle(movie.getMovieTitle())
                .ratingScore(rating.getRatingScore())
                .likesList(Collections.emptyList())
                .build();

        // When
        reviewService.insertReview(reviewDTO);

        // Then
        ReviewDTO reviewDTO1 = reviewService.getReview(reviewDTO.getReviewId());
        assertNotNull(reviewDTO1);
        assertEquals(reviewDTO.getReviewContent(), reviewDTO1.getReviewContent());
    }

    @Test
    void updateReview() {
    }

    @Test
    void getReviewListByMovieId() {
    }
}