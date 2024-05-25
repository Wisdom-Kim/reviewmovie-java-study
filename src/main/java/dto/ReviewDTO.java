package dto;

import domain.Review;
import domain.Movie;
import domain.User;
import domain.Likes;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ReviewDTO {
    private int reviewId;
    private String reviewContent;
    private Date reviewDate;
    private UserDTO user;
    private MovieDTO movie;
    private List<LikesDTO> likeList = new ArrayList<>();

    @Builder
    public ReviewDTO(int reviewId, String reviewContent, Date reviewDate, UserDTO user, MovieDTO movie) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.user = user;
        this.movie = movie;
    }

    public static ReviewDTO fromEntity(Review review) {
        ReviewDTO reviewDTO = ReviewDTO.builder()
                .reviewId(review.getReviewId())
                .reviewContent(review.getReviewContent())
                .reviewDate(review.getReviewDate())
                .user(UserDTO.fromEntity(review.getUser()))
                .movie(MovieDTO.fromEntity(review.getMovie()))
                .rating(review.getRating() != null ? RatingDTO.fromEntity(review.getRating()) : null)
                .build();

        List<LikesDTO> likeDTOList = new ArrayList<>();
        for (Likes likes : review.getLikesList()) {
            likeDTOList.add(LikesDTO.fromEntity(likes));
        }
        reviewDTO.setLikeList(likeDTOList);

        return reviewDTO;
    }


    public Review toEntity() {
        return Review.builder()
                .reviewId(this.reviewId)
                .reviewContent(this.reviewContent)
                .reviewDate(this.reviewDate)
                .user(this.user.toEntity())
                .movie(this.movie.toEntity())
                .build();
    }
}

