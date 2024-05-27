package dto;

import domain.*;
import lombok.*;

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
    private int userId;
    private String userName;
    private int movieId;
    private String movieTitle;
    private int ratingId;
    private int ratingScore;

    @Builder
    public ReviewDTO(int reviewId, String reviewContent, Date reviewDate, int userId, String userName, int movieId, String movieTitle, int ratingId, int ratingScore) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.userId = userId;
        this.userName = userName;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.ratingId = ratingId;
        this.ratingScore = ratingScore;
    }

    public static ReviewDTO fromEntity(Review review) {
        return ReviewDTO.builder()
                .reviewId(review.getReviewId())
                .reviewContent(review.getReviewContent())
                .reviewDate(review.getReviewDate())
                .userId(review.getUser().getUserId())
                .userName(review.getUser().getUserName())
                .movieId(review.getMovie().getMovieId())
                .movieTitle(review.getMovie().getMovieTitle())
                .ratingId(review.getRating().getRatingId())
                .ratingScore(review.getRating().getRatingScore())
                .build();
    }

    public Review toEntity() {
        User user = User.builder()
                .userId(this.userId)
                .build();

        Movie movie = Movie.builder()
                .movieId(this.movieId)
                .build();

        Rating rating = Rating.builder()
                .ratingId(this.ratingId)
                .ratingScore(this.ratingScore)
                .build();

        return Review.builder()
                .reviewId(this.reviewId)
                .reviewContent(this.reviewContent)
                .reviewDate(this.reviewDate)
                .user(user)
                .movie(movie)
                .rating(rating)
                .build();
    }

}