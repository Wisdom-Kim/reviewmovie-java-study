package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, unique = true)
    private String userAccountId;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userName;

    @Temporal(TemporalType.DATE)
    private Date userBirthday;

    private boolean userType;
<<<<<<< Updated upstream
	
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
=======

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likeList = new ArrayList<>();
>>>>>>> Stashed changes
}