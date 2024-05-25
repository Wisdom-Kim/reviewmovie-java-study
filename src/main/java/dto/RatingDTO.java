package dto;

import domain.Rating;
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
public class RatingDTO {

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
