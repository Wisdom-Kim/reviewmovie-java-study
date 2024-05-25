package service;

import domain.Rating;
import dto.RatingDTO;
import org.junit.jupiter.api.Test;
import repository.RatingRepository;

import static org.junit.jupiter.api.Assertions.*;

class RatingServiceTest {

    @Test
    void insertRating() {

        RatingService ratingService = new RatingService();
        RatingRepository repository = new RatingRepository();
        RatingDTO ratingDTO = RatingDTO.builder()
                .ratingId(1)
                .ratingScore(5)
                .build();

        ratingService.insertRating(ratingDTO);
        Rating rating  = repository.findOne(ratingDTO.getRatingId());

        assertEquals(rating.getRatingId(),1, "이 리뷰의 id는 1이여야 합니다.");


    }

    @Test
    void getRating() {
    }

    @Test
    void deleteRating() {
    }
}