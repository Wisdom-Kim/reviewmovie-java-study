package domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"movie", "user"})
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "rating_id")
    private Rating rating;

    @Column(name = "review_content", nullable = false)
    private String reviewContent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "review_date", nullable = false)
    private Date reviewDate;

    public void setMovie(Movie movie) {
        this.movie = movie;
        if (movie != null && !movie.getReviewList().contains(this)) {
            movie.getReviewList().add(this);
        }
    }

    public void setUser(User user) {
        this.user = user;
        if (user != null && !user.getReviewList().contains(this)) {
            user.getReviewList().add(this);
        }
    }
}