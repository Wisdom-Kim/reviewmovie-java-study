package dto;

import domain.Movie;
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
public class MovieDTO {

	//Adjust fields according to the domain
//	private boolean likeStatement;
//	private int userId;
//	private int reviewId;
//	
//	@Builder
//	public MovieDTO(boolean likeStatement,int userId,int reviewId) {
//		
//		this.likeStatement = likeStatement;
//		this.userId = userId;
//		this.reviewId = reviewId;
//	}
//	
//	public static Movie toEntity(MovieDTO movieDTO) {
//		return Movie.builder()
//					.deptno(deptDTO.getDeptno())
//					.dname(deptDTO.getDname())
//					.loc(deptDTO.getLoc())
//					.build();
//	}
	
}
