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
    private int reviewId; //리뷰ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie; //매핑된 영화

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; //매핑된 작성자 유저

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id")
    private Rating rating; //매핑된 평점

    @Column(name = "review_content", nullable = false)
    private String reviewContent; //리뷰 내용

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "review_date", nullable = false)
    private Date reviewDate; //작성일자

    public void setMovie(Movie movie) { //편의 메서드(movie 쪽의 리뷰 리스트 추가)
        this.movie = movie;
        if (movie != null && !movie.getReviewList().contains(this)) {
            movie.getReviewList().add(this);
        }
    }

    public void setUser(User user) { //편의 메서드(user 쪽의 리뷰 리스트 추가)
        this.user = user;
        if (user != null && !user.getReviewList().contains(this)) {
            user.getReviewList().add(this);
        }
    }
}