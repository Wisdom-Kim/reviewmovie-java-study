package dto;

import domain.Like;
import domain.Review;
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
public class LikeDTO {

	private int likeId;
	private boolean isLike;
	private User user;
	private Review review;

	@Builder
	public LikeDTO(int likeId, boolean isLike,User user,Review review) {
		this.likeId = likeId;
		this.isLike = isLike;
		this.user = user;
		this.review = review;
	}

	public static Like toEntity(LikeDTO likeDTO) {
		return Like.builder()
				.likeId(likeDTO.getLikeId())
                .isLike(likeDTO.isLike())
                .user(likeDTO.getUser())
                .review(likeDTO.getReview())
                .build();
	}
	
}