package dto;

import domain.Likes;
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
public class LikesDTO {

	private int likeId;
	private boolean isLike;
	private User user;
	private Review review;

	@Builder
	public LikesDTO(int likeId, boolean isLike, User user, Review review) {
		this.likeId = likeId;
		this.isLike = isLike;
		this.user = user;
		this.review = review;
	}

	public static Likes toEntity(LikesDTO likesDTO) {
		return Likes.builder()
				.likesId(likesDTO.getLikeId())
                .isLikes(likesDTO.isLike())
                .user(likesDTO.getUser())
                .review(likesDTO.getReview())
                .build();
	}
	
}