package dto;

import domain.Rating;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class RatingDTO {
    //DTO: 레퍼지토리와 엔터티 사이 계층
    //데이터 전송과 수정을 용이하게 한다

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
