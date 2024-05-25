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


	//Adjust fields according to the domain
	private int reviewId;
    private Movie movie;
    private User user;
    private Rating rating;
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


    public Review toEntity(Review existingReview, Rating newRating) {
        //평점 정보
        return Review.builder()
                .reviewId(existingReview.getReviewId())
                .movie(existingReview.getMovie())
                .user(existingReview.getUser())
                .reviewContent(this.reviewContent)
                .rating(newRating)
                .reviewDate(existingReview.getReviewDate()) // 생성 시 자동으로 설정되는 필드 유지
                .build();
    }
}

