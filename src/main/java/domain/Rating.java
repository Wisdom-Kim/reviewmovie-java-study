package domain;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private int ratingId;

    @Column(name = "rating_score", nullable = false)
    private int ratingScore;

    @OneToOne(mappedBy = "rating", cascade = CascadeType.ALL)
    private Review review;
}
