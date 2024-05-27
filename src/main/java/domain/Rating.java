package domain;

import jakarta.persistence.*;
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
    private int ratingId; //평점 ID

    @Column(name = "rating_score", nullable = false)
    private int ratingScore; //평점값

    @OneToOne(mappedBy = "rating", cascade = CascadeType.ALL)
    private Review review; //매핑된 리뷰
}
