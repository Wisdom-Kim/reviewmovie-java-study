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

<<<<<<< Updated upstream
////Adjust fields according to the domain
//	private boolean likeStatement;
//	private int userId;
//	private int reviewId;
//	
//	@Builder
//	public RatingDTO(boolean likeStatement,int userId,int reviewId) {
//		
//		this.likeStatement = likeStatement;
//		this.userId = userId;
//		this.reviewId = reviewId;
//	}
//	
//	public static Movie toEntity(RatingDTO ratingDTO) {
//		return Movie.builder()
//					.deptno(ratingDTO.getDeptno())
//					.dname(ratingDTO.getDname())
//					.loc(ratingDTO.getLoc())
//					.build();
//	}
	
	
}
=======
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
>>>>>>> Stashed changes
