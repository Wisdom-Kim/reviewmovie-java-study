package dto;

import domain.*;
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
    private User user;
    private String userName;
    private Movie movie;
    private Rating rating;
    private List<Likes> likesList;

    @Builder
    public ReviewDTO(int reviewId, String reviewContent, Date reviewDate, User user, String userName, Movie movie, Rating rating, List<Likes> likesList) {
        this.reviewId = reviewId;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.user = user;
        this.userName = userName;
        this.movie = movie;
        this.rating = rating;
        this.likesList = likesList;
    }


    public static ReviewDTO fromEntity(Review review) {
        //JPA로부터 받은 Entity를 DTO로 변경
        return ReviewDTO.builder()
                .reviewId(review.getReviewId())
                .reviewContent(review.getReviewContent())
                .reviewDate(review.getReviewDate())
                .user(review.getUser())
                .movie(review.getMovie())
                .rating(review.getRating())
                .likesList(review.getLikesList())
                .build();
    }

    public Review toEntity() {
        //DTO를 받아 Entity로 변경
        return Review.builder()
                .reviewId(this.reviewId)
                .movie(this.movie)
                .user(this.user)
                .reviewContent(this.reviewContent)
                .rating(this.rating)
                .reviewDate(this.reviewDate) // 리뷰 작성 시간이 수정되면 안된다
                .build();
    }
}
