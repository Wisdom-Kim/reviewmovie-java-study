package service;

import domain.Movie;
import domain.Rating;
import domain.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;
import util.JpaUtil;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReviewServiceTest {

    @Test
    void insertReview() {

//        String PERSISTENCE_UNIT = "jpa_config";
//        EntityManagerFactory emf = null;
//        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        ReviewService reviewService = new ReviewService();



        Rating rating = Rating.builder().ratingId(1).ratingScore(1).build();
//        Review review = Review.builder()
//                .reviewId(1)
//                .user(1);
//                .
//                .build();
        //int reviewId, int movieId, int userId, String reviewContent, int ratingId
//        Review review = reviewService.insertReview("이건 1점이 아니다. 6점을 주고싶은 내 마음이다.",rating);
        //결과값이 true 혹은 false가 나와야함!
//        assertEquals(review.getReviewContent(),"이건 1점이 아니다. 6점을 주고싶은 내 마음이다.");
    }

    @Test
    void getReviewListByMovieId() {
        ReviewService reviewService = new ReviewService();
        EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
//            Movie movie = Movie.builder()
//                    .movieId(1)  // movieId를 int로 설정
//                    .movieTitle("기생충")
//                    .movieDirector("봉준호")
//                    .moviePoster("https://img.movist.com/?img=/x00/05/04/96_p1.jpg")
//                    .movieType("스릴러")
//                    .movieReleaseDate(new Date())
//                    .build();
//            Movie movie =em.find(Movie.class, 1);
//            List<Review> reviewList = reviewService.getReviewListByMovieId(1);  // findListByMovieI
            tx.commit();


            insertReview();
//            System.out.println(reviewList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}