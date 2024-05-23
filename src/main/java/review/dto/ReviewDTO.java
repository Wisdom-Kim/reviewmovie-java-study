package review.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewDTO {
    private int reviewId;
    private int movieId;
    private int userId;
    private int ratingId;
    private String reviewContent;
    private Date reviewDate;

    
}