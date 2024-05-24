package service;

import domain.Rating;
import domain.Review;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReviewServiceTest {

    @Test
    void insertReview() {

        String PERSISTENCE_UNIT = "jpa_config";
        EntityManagerFactory emf = null;
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
//        ReviewService reviewService = new ReviewService();
//        boolean review = false;


//        Rating rating = Rating.builder().ratingId(1).ratingScore(1).build();
//        review = reviewService.insertReview("이건 1점이 아니다. 6점을 주고싶은 내 마음이다.",rating);
        //결과값이 true 혹은 false가 나와야함!
        assertNotNull(emf);
//        assertTrue(review, "Review should be successfully inserted");
    }
}