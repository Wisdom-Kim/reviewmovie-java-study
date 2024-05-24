package dto;

import java.util.Date;

import domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    private String userPasswd;
    private String userName;
    private Date userBirthday;
    private boolean userType;
	
	public UserDTO(String accountId, String passwd, String username, Date birthday, boolean type) {
		this.userAccountId = accountId;
		this.userPasswd = passwd;
		this.userName = username;
		this.userBirthday = birthday;
		this.userType = type;
	}
	
	public static User toEntity(UserDTO userDTO) {
		return User.builder()
					.userAccountId(userDTO.getUserAccountId())
					.userPasswd(userDTO.getUserPasswd())
					.userName(userDTO.getUserName())
					.userBirthday(userDTO.getUserBirthday())
					.userType(userDTO.isUserType())
					.build();
	}
}
