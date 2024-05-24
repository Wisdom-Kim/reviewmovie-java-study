package dto;

import domain.Like;
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
public class LikeDTO {

	//도메인 필드에 맞게 수정
//	private boolean likeStatement;
//	private int userId;
//	private int reviewId;
//	
//	@Builder
//	public LikeDTO(boolean likeStatement,int userId,int reviewId) {
//		
//		this.likeStatement = likeStatement;
//		this.userId = userId;
//		this.reviewId = reviewId;
//	}
//	
//	public static Like toEntity(LikeDTO likeDTO) {
//		return Like.builder()
//					.deptno(deptDTO.getDeptno())
//					.dname(deptDTO.getDname())
//					.loc(deptDTO.getLoc())
//					.build();
//	}
	
}