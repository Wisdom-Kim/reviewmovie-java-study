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
@Builder
@AllArgsConstructor
public class LikesDTO {
    private int likesId;
    private int userId;
    private int reviewId;

    public static LikesDTO fromEntity(Likes likes) {
        return LikesDTO.builder()
                .likesId(likes.getLikesId())
                .userId(likes.getUser().getUserId())
                .reviewId(likes.getReview().getReviewId())
                .build();
    }

    public static Likes toEntity(LikesDTO likesDTO) {
        User user = User.builder().userId(likesDTO.getUserId()).build(); // Assuming User entity with just ID
        Review review = Review.builder().reviewId(likesDTO.getReviewId()).build(); // Assuming Review entity with just ID
        return Likes.builder()
                .likesId(likesDTO.getLikesId())
                .user(user)
                .review(review)
                .build();
    }
}
