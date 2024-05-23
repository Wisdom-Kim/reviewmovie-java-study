package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@DiscriminatorValue(value = "movie")
public class Movie {

	@Id
	@Column(name = "movie_id")
	private String movieId;
	
	@Column(name = "movie_title")
    private String movieTitle;
	
	@Column(name = "movie_director")
    private String movieDirector;
	
	@Column(name = "movie_poster")
    private String moviePoster;
	
	@Column(name = "movie_type")
    private String movieType;
	
	@Column(name = "movie_release_date")
    private Date movieReleaseDate;
	
	@OneToMany(mappedBy = "movie")
	private List<Review> reviewList = new ArrayList<>();

}
