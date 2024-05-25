package dto;

import domain.Like;
import domain.Review;
import domain.User;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LikeDTO {
    private int likeId;
    private boolean likeStatement;
    private UserDTO user;
    private ReviewDTO review;

    @Builder
    public LikeDTO(int likeId, boolean likeStatement, UserDTO user, ReviewDTO review) {
        this.likeId = likeId;
        this.likeStatement = likeStatement;
        this.user = user;
        this.review = review;
    }

    public static LikeDTO fromEntity(Like like) {
        return LikeDTO.builder()
                .likeId(like.getLikeId())
                .likeStatement(like.isLikeStatement())
                .user(UserDTO.fromEntity(like.getUser()))
                .review(ReviewDTO.fromEntity(like.getReview()))
                .build();
    }

    public Like toEntity() {
        return Like.builder()
                .likeId(this.likeId)
                .likeStatement(this.likeStatement)
                .user(this.user.toEntity())
                .review(this.review.toEntity())
                .build();
    }
}