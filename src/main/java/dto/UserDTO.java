package dto;

import domain.User;
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
public class UserDTO {
	//도메인 필드에 맞게 수정
//	private boolean likeStatement;
//	private int userId;
//	private int reviewId;
//	
//	@Builder
//	public UserDTO(boolean likeStatement,int userId,int reviewId) {
//		
//		this.likeStatement = likeStatement;
//		this.userId = userId;
//		this.reviewId = reviewId;
//	}
//	
//	public static Like toEntity(UserDTO userDTO) {
//		return User.builder()
//					.deptno(userDTO.getDeptno())
//					.dname(userDTO.getDname())
//					.loc(userDTO.getLoc())
//					.build();
//	}
}
