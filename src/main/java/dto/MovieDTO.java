package dto;

import domain.Movie;
import domain.Review;
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
    private double averageRating;
    private List<ReviewDTO> reviewList = new ArrayList<>();
    private List<LikesDTO> likesList = new ArrayList<>();

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
        double totalRating = 0;
        int numReviews = 0;
        for (Review review : movie.getReviewList()) {
            reviewDTOList.add(ReviewDTO.fromEntity(review));
            if (review.getRating() != null) {
                totalRating += review.getRating().getRatingScore();
                numReviews++;
            }
        }
        movieDTO.setReviewList(reviewDTOList);
        movieDTO.setAverageRating(numReviews > 0 ? totalRating / numReviews : 0);

//        List<LikesDTO> likesDTOList = new ArrayList<>();
//        for (Likes likes : movie.getLikesList()) {
//            likesDTOList.add(LikesDTO.fromEntity(likes));
//        }
//        movieDTO.setLikesList(likesDTOList);

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