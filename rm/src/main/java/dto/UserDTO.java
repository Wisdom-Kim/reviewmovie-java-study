package dto;

import domain.User;
import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserDTO {
    private int userId;
    private String userAccountId;
    private String userPassword;
    private String userName;
    private Date userBirthday;
    private boolean userType;

    public static UserDTO fromEntity(User user) {
        return UserDTO.builder()
                .userId(user.getUserId())
                .userAccountId(user.getUserAccountId())
                .userPassword(user.getUserPassword())
                .userName(user.getUserName())
                .userBirthday(user.getUserBirthday())
                .userType(user.isUserType())
                .build();
    }

    public User toEntity() {
        return User.builder()
                .userId(this.userId)
                .userAccountId(this.userAccountId)
                .userPassword(this.userPassword)
                .userName(this.userName)
                .userBirthday(this.userBirthday)
                .userType(this.userType)
                .build();
    }
}