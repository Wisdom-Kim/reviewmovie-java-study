package dto;

import domain.Rating;
import domain.Review;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RatingDTO {
    private int ratingId;
    private int ratingScore;
    private ReviewDTO review;

    @Builder
    public RatingDTO(int ratingId, int ratingScore, ReviewDTO review) {
        this.ratingId = ratingId;
        this.ratingScore = ratingScore;
        this.review = review;
    }

    public static RatingDTO fromEntity(Rating rating) {
        return RatingDTO.builder()
                .ratingId(rating.getRatingId())
                .ratingScore(rating.getRatingScore())
                .review(ReviewDTO.fromEntity(rating.getReview()))
                .build();
    }

    public Rating toEntity() {
        return Rating.builder()
                .ratingId(this.ratingId)
                .ratingScore(this.ratingScore)
                .review(this.review.toEntity())
                .build();
    }
}

