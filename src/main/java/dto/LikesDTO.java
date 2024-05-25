package dto;

import domain.Likes;
import domain.Review;
import domain.User;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class LikesDTO {
    private int likesId;
    private boolean likeStatement;
    private UserDTO user;
    private ReviewDTO review;

    @Builder
    public LikesDTO(int likesId, boolean likeStatement, UserDTO user, ReviewDTO review) {
        this.likesId = likesId;
        this.likeStatement = likeStatement;
        this.user = user;
        this.review = review;
    }

    public static LikesDTO fromEntity(Likes likes) {
        return LikesDTO.builder()
                .likesId(likes.getLikesId())
                .likeStatement(likes.isLikeStatement())
                .user(UserDTO.fromEntity(likes.getUser()))
                .review(ReviewDTO.fromEntity(likes.getReview()))
                .build();
    }

    public Likes toEntity() {
        return Likes.builder()
                .likesId(this.likesId)
                .likeStatement(this.likeStatement)
                .user(this.user.toEntity())
                .review(this.review.toEntity())
                .build();
    }
}