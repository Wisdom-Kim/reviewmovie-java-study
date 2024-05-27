package dto;

import domain.Likes;
import domain.Movie;
import domain.Rating;
import domain.Review;
import domain.User;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    private int ratingScore;
    private List<Likes> likesList;

    @Builder
    public ReviewDTO(int reviewId, String reviewContent, Date reviewDate, int userId, String userName, int movieId, String movieTitle, int ratingScore, List<Likes> likesList) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.userId = userId;
        this.userName = userName;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.ratingScore = ratingScore;
        this.likesList = likesList;
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
                .ratingScore(review.getRating().getRatingScore())
                .likesList(review.getLikesList())
                .build();
    }

    public Review toEntity() {
        //관련객체를 새로 만들고,Entity로 만든다. 이 때 의존관계인 얘들을 주입할것

        User user = new User();
        user.setUserId(this.userId);
        Movie movie = new Movie();
        movie.setMovieId(this.movieId);
        Rating ratnig = new Rating();
        ratnig.setRatingScore(this.ratingScore);

        return Review.builder()
                .reviewContent(this.reviewContent)
                .reviewDate(this.reviewDate)
                .user(user)
                .movie(movie)
                .rating(ratnig) //평가가 먼저 생성되어야 주입이 가능해진다
                .likesList(this.likesList)
                .build();
    }
}