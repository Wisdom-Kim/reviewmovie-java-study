package dto;
<<<<<<< Updated upstream
import domain.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
=======

import domain.Review;
import domain.Movie;
import domain.User;
<<<<<<< Updated upstream
import domain.Like;
=======
import domain.Likes;
import domain.Rating;
>>>>>>> Stashed changes
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
<<<<<<< Updated upstream
>>>>>>> Stashed changes

import java.util.Date;
import java.util.List;
=======
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
    private List<LikeDTO> likeList = new ArrayList<>();
=======
    private RatingDTO rating;
    private List<LikesDTO> likeList = new ArrayList<>();
>>>>>>> Stashed changes

<<<<<<< Updated upstream
	//Adjust fields according to the domain
	private int reviewId;
    private Movie movie;
    private User user;
    private Rating rating;
    private String reviewContent;
    private Date reviewDate;

    @Builder
    public ReviewDTO(int reviewId, Movie movie, User user, Rating rating, String reviewContent, Date reviewDate, List<Likes> listLike) {
        this.reviewId = reviewId;
        this.movie = movie;
        this.user = user;
        this.rating = rating;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
    }


	public static Review toEntity(ReviewDTO reviewDTO) {
		return Review.builder()
                .reviewId(reviewDTO.getReviewId())
                .movie(reviewDTO.getMovie())
                .user(reviewDTO.getUser())
                .rating(reviewDTO.getRating())
                .reviewContent(reviewDTO.getReviewContent())
                .reviewDate(reviewDTO.getReviewDate())
                .build();
	}
}
=======
    @Builder
    public ReviewDTO(int reviewId, String reviewContent, Date reviewDate, UserDTO user, MovieDTO movie, RatingDTO rating) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.user = user;
        this.movie = movie;
        this.rating = rating;
    }

    public static ReviewDTO fromEntity(Review review) {
        ReviewDTO reviewDTO = ReviewDTO.builder()
<<<<<<< Updated upstream
                .reviewId(review.getReviewId())
                .reviewContent(review.getReviewContent())
                .reviewDate(review.getReviewDate())
                .user(UserDTO.fromEntity(review.getUser()))
                .movie(MovieDTO.fromEntity(review.getMovie()))
                .build();

        List<LikeDTO> likeDTOList = new ArrayList<>();
        for (Like like : review.getLikeList()) {
            likeDTOList.add(LikeDTO.fromEntity(like));
=======
            .reviewId(review.getReviewId())
            .reviewContent(review.getReviewContent())
            .reviewDate(review.getReviewDate())
            .user(UserDTO.fromEntity(review.getUser()))
            .movie(MovieDTO.fromEntity(review.getMovie()))
            .rating(review.getRating() != null ? RatingDTO.fromEntity(review.getRating()) : null)
            .build();

        List<LikesDTO> likeDTOList = new ArrayList<>();
        if (review.getLikesList() != null) {
            for (Likes likes : review.getLikesList()) {
                likeDTOList.add(LikesDTO.fromEntity(likes));
            }
>>>>>>> Stashed changes
        }
        reviewDTO.setLikeList(likeDTOList);

        return reviewDTO;
    }

    public Review toEntity() {
        return Review.builder()
            .reviewId(this.reviewId)
            .reviewContent(this.reviewContent)
            .reviewDate(this.reviewDate)
            .user(this.user != null ? this.user.toEntity() : null)
            .movie(this.movie != null ? this.movie.toEntity() : null)
            .rating(this.rating != null ? this.rating.toEntity() : null)
            .build();
    }
<<<<<<< Updated upstream
}
>>>>>>> Stashed changes
=======
}
>>>>>>> Stashed changes
