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
    public ReviewDTO(int reviewId, Movie movie, User user, Rating rating, String reviewContent, Date reviewDate, List<Like> listLike) {
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
