package service;

import domain.Rating;
import dto.RatingDTO;
import repository.RatingRepository;

public class RatingService {

    private final RatingRepository ratingRepository = RatingRepository.getInstance();

    public void insertRating(RatingDTO ratingDTO) {
        Rating rating = ratingDTO.toEntity();
        ratingRepository.save(rating);
    }

    public RatingDTO getRating(int ratingId) {
        Rating rating = ratingRepository.findOne(ratingId);
        return RatingDTO.builder()
                .ratingId(rating.getRatingId())
                .ratingScore(rating.getRatingScore())
                .build();
    }

    public void deleteRating(int ratingId) {
        Rating rating = ratingRepository.findOne(ratingId);
        if (rating != null) {
            ratingRepository.delete(rating);
        }
    }
}
