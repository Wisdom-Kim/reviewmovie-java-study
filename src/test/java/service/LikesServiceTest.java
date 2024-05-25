package service;

import dto.LikesDTO;
import dto.RatingDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LikesServiceTest {


    private final LikesService likesService = new LikesService();

    @Test
    void insertLikes() {
        LikesDTO likesDTO = LikesDTO.builder()
                .userId(1)
                .reviewId(1)
                .build();

        likesService.insertLikes(likesDTO);
        LikesDTO retrievedLikes = likesService.getLikes(1);

        assertNotNull(retrievedLikes);
        assertEquals(1, retrievedLikes.getLikesId(), "Like id 1일것");
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