package dto;

import domain.Like;
import domain.Movie;
import domain.Review;
import domain.User;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MovieDTO {
    private int movieId;
    private String movieTitle;
    private String movieDirector;
    private String moviePoster;
    private String movieType;
    private Date movieReleaseDate;
    private List<ReviewDTO> reviewList = new ArrayList<>();
    private List<LikeDTO> likeList = new ArrayList<>();

<<<<<<< Updated upstream
	//Adjust fields according to the domain
//	private boolean likeStatement;
//	private int userId;
//	private int reviewId;
//	
//	@Builder
//	public MovieDTO(boolean likeStatement,int userId,int reviewId) {
//		
//		this.likeStatement = likeStatement;
//		this.userId = userId;
//		this.reviewId = reviewId;
//	}
//	
//	public static Movie toEntity(MovieDTO movieDTO) {
//		return Movie.builder()
//					.deptno(deptDTO.getDeptno())
//					.dname(deptDTO.getDname())
//					.loc(deptDTO.getLoc())
//					.build();
//	}
	
}
=======
    @Builder
    public MovieDTO(int movieId, String movieTitle, String movieDirector, String moviePoster, String movieType, Date movieReleaseDate) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieDirector = movieDirector;
        this.moviePoster = moviePoster;
        this.movieType = movieType;
        this.movieReleaseDate = movieReleaseDate;
    }

    public static MovieDTO fromEntity(Movie movie) {
        MovieDTO movieDTO = MovieDTO.builder()
                .movieId(movie.getMovieId())
                .movieTitle(movie.getMovieTitle())
                .movieDirector(movie.getMovieDirector())
                .moviePoster(movie.getMoviePoster())
                .movieType(movie.getMovieType())
                .movieReleaseDate(movie.getMovieReleaseDate())
                .build();

        List<ReviewDTO> reviewDTOList = new ArrayList<>();
        for (Review review : movie.getReviewList()) {
            reviewDTOList.add(ReviewDTO.fromEntity(review));
        }
        movieDTO.setReviewList(reviewDTOList);

        List<LikeDTO> likeDTOList = new ArrayList<>();
        for (Like like : movie.getLikeList()) {
            likeDTOList.add(LikeDTO.fromEntity(like));
        }
        movieDTO.setLikeList(likeDTOList);

        return movieDTO;
    }

    public Movie toEntity() {
        return Movie.builder()
                .movieId(this.movieId)
                .movieTitle(this.movieTitle)
                .movieDirector(this.movieDirector)
                .moviePoster(this.moviePoster)
                .movieType(this.movieType)
                .movieReleaseDate(this.movieReleaseDate)
                .build();
    }
}
>>>>>>> Stashed changes
