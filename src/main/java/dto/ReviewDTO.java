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
import domain.Like;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
>>>>>>> Stashed changes

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
    private List<LikeDTO> likeList = new ArrayList<>();

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
                .build();

        List<LikeDTO> likeDTOList = new ArrayList<>();
        for (Like like : review.getLikeList()) {
            likeDTOList.add(LikeDTO.fromEntity(like));
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
>>>>>>> Stashed changes
