package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@DiscriminatorValue(value = "user")
public class User {
	@Id
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
	
	@OneToMany(mappedBy = "user")
	private List<Review> reviewList = new ArrayList<>();
    
	@OneToMany(mappedBy = "user")
	private List<Likes> likeList = new ArrayList<>();
	
	public User(String accountId, String passwd, String username, Date birthday, boolean type) {
		this.userAccountId = accountId;
		this.userPasswd = passwd;
		this.userName = username;
		this.userBirthday = birthday;
		this.userType = type;
	}
	
	public static UserDTO toDTO(User user) {
		return UserDTO.builder()
				.userAccountId(user.getUserAccountId())
				.userPasswd(user.getUserPasswd())
				.userName(user.getUserName())
				.userBirthday(user.getUserBirthday())
				.userType(user.isUserType())
				.build();
	}
}