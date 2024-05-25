package domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@DiscriminatorValue(value = "rating")
public class Rating {
	
	@Id
	@Column(name = "rating_id")
	private int ratingId;
	
	@Column(name = "rating_score")
	private int ratingScore;


	
}
