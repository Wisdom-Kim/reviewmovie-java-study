package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@ToString //테스트용
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "movie_id"})
}) //각 유저는 한 영화에 대해 리뷰 하나만 적을 수 있으므로 복합키 대신 대리키로 제약조건 설정
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private int reviewId;

    @Column(nullable = false, name = "review_content")
    private String reviewContent;

    @Column(name = "review_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Likes> likesList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id")
    private Rating rating;

    public void addLike(Likes like) {
        likesList.add(like);
        like.setReview(this);
    }

    public void removeLike(Likes like) {
        likesList.remove(like);
        like.setReview(null);
    }
}
