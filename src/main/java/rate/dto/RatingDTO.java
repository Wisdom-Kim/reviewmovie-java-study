package rate.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RatingDTO {
    private int ratingId;
    private int userId;
    private int movieId;
    private int rating;
    private Date ratingDate;
	
}
