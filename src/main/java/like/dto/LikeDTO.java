package like.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LikeDTO {
    private int likeId;
    private int userId;
    private int reviewId;
    private boolean likeStatement;

}
