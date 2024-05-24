package dto;

import domain.Review;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ReviewDTO {

	//도메인 필드에 맞게 수정
//	private boolean likeStatement;
//	private int userId;
//	private int reviewId;
//	
//	@Builder
//	public ReviewDTO(boolean likeStatement,int userId,int reviewId) {
//		
//		this.likeStatement = likeStatement;
//		this.userId = userId;
//		this.reviewId = reviewId;
//	}
//	
//	public static Movie toEntity(ReviewDTO reviewDTO) {
//		return Review.builder()
//					.deptno(ratingDTO.getDeptno())
//					.dname(ratingDTO.getDname())
//					.loc(ratingDTO.getLoc())
//					.build();
//	}
}
