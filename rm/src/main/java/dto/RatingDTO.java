package dto;

import domain.Rating;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RatingDTO {
    private int ratingId;
    private int ratingScore;

    @Builder
    public RatingDTO(int ratingId, int ratingScore) {
        this.ratingId = ratingId;
        this.ratingScore = ratingScore;
    }

    public static RatingDTO fromEntity(Rating rating) {
        return RatingDTO.builder()
                .ratingId(rating.getRatingId())
                .ratingScore(rating.getRatingScore())
                .build();
    }

    public Rating toEntity() {
        return Rating.builder()
                .ratingId(this.ratingId)
                .ratingScore(this.ratingScore)
                .build();
    }
}