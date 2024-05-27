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
    //DTO: 레퍼지토리와 엔터티 사이 계층
    //데이터 전송과 수정을 용이하게 한다
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