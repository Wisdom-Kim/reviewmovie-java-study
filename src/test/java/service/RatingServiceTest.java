package service;

import dto.RatingDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatingServiceTest {

    private final RatingService ratingService = RatingService.getInstance();

    @Test
    void insertRating() {
        RatingDTO ratingDTO = RatingDTO.builder()
                .ratingScore(5)
                .build();

        ratingService.insertRating(ratingDTO);
        RatingDTO retrievedRating = ratingService.getRating(1);

        assertNotNull(retrievedRating);
        assertEquals(retrievedRating.getRatingId(), 1, "해당 평점은 id가 1이어야 함");
    }

    @Test
    void getRating() {
        RatingDTO ratingDTO = RatingDTO.builder()
                .ratingScore(5)
                .build();
        ratingService.insertRating(ratingDTO);

        RatingDTO retrievedRating = ratingService.getRating(1);

        assertNotNull(retrievedRating);
        assertEquals(retrievedRating.getRatingScore(), 5, "해당 평점은 점수가 5점이어야 함");
    }

    @Test
    void deleteRating() {
        RatingDTO ratingDTO = RatingDTO.builder()
                .ratingScore(5)
                .build();
        ratingService.insertRating(ratingDTO);

        ratingService.deleteRating(1);
        assertThrows(NullPointerException.class, () -> {
            ratingService.getRating(1);
        }, "삭제 후 null이 될 것");

    }
}
