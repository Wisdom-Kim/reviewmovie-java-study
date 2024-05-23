package user.dto;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
    private int userId;
	
	@Column(name = "user_account_id")
    private String userAccountId;
	
	@Column(name = "user_passwd")
    private String userPasswd;
	
	@Column(name = "user_name")
    private String userName;
	
	@Column(name = "user_birthday")
    private Date userBirthday;
	
	@Column(name = "user_type")
    private boolean userType;
	
	public UserDTO(String accountId, String passwd, String username, Date birthday, boolean type) {
		this.userAccountId = accountId;
		this.userPasswd = passwd;
		this.userName = username;
		this.userBirthday = birthday;
		this.userType = type;
	}
    
}