package dto;
import domain.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    @Builder
    public ReviewDTO(int reviewId, Movie movie, User user, Rating rating, String reviewContent, Date reviewDate, List<Likes> listLike) {
        this.reviewId = reviewId;
        this.movie = movie;
        this.user = user;
        this.rating = rating;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
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
