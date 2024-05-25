package service;

import dto.LikesDTO;
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

        assertNotNull(retrievedLikes, "Likes should not be null after insertion");
        assertEquals(1, retrievedLikes.getLikesId(), "Likes ID should be 1");
    }

    @Test
    void getLikes() {
    }

    @Test
    void getAllLikes() {
    }

    @Test
    void deleteLikes() {
    }
}