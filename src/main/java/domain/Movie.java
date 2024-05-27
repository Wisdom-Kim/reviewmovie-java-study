package domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"reviewList"})
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId; //영화Id

    @Column(name = "movie_title", nullable = false)
    private String movieTitle; //영화제목

    @Column(name = "movie_director", nullable = false)
    private String movieDirector; //영화감독

    @Column(name = "movie_poster", nullable = false)
    private String moviePoster; //영화 포스터 Url

    @Column(name = "movie_type", nullable = false)
    private String movieType; //영화 장르

    @Temporal(TemporalType.DATE)
    @Column(name = "movie_release_date", nullable = false)
    private Date movieReleaseDate;//상영일자

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList = new ArrayList<>(); //해당 영화에 달린 리뷰 리스트

}
