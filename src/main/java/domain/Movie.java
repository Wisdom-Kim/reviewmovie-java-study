package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column(nullable = false)
    private String movieTitle;

    @Column(nullable = false)
    private String movieDirector;

    @Column(nullable = false)
    private String moviePoster;

    @Column(nullable = false)
    private String movieType;

    @Temporal(TemporalType.DATE)
    private Date movieReleaseDate;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList = new ArrayList<>();
    
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Likes> likesList = new ArrayList<>();

    public List<Likes> getLikesList() {
        return likesList;
    }
}