package service;

import domain.Likes;
import dto.LikesDTO;
import dto.RatingDTO;
import repository.LikesRepository;

import java.util.List;
import java.util.stream.Collectors;

public class LikesService {

    private final LikesRepository likesRepository = LikesRepository.getInstance();

    public void insertLikes(LikesDTO likesDTO) {
        Likes likes = likesDTO.toEntity();
        likesRepository.save(likes);
    }

    public LikesDTO getLikes(int likesId) {
        Likes likes = likesRepository.findOne(likesId);
        return LikesDTO.builder()
                .likesId(likesId)
                .reviewId(likes.getReview().getReviewId())
                .build();
    }

    public List<LikesDTO> getAllLikes() {
        List<Likes> likesList = likesRepository.findAll();
        return likesList.stream()
                .map(LikesDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteLikes(int likesId) {
        Likes likes = likesRepository.findOne(likesId);
        if (likes != null) {
            likesRepository.delete(likes);
        }
    }
}
