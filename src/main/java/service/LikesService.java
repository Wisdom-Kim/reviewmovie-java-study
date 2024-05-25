package service;

import domain.Likes;
import dto.LikesDTO;
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
        if (likes == null) {
            throw new NullPointerException("Likes not found");
        }
        return LikesDTO.fromEntity(likes);
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
