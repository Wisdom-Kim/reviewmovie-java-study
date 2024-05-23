package movie.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MovieDTO {
    private int movieId;
    private String movieTitle;
    private String movieDirector;
    private String moviePoster;
    private String movieType;
    private Date movieReleaseDate;

}
