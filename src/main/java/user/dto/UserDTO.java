package user.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private int userId;
    private String userAccountId;
    private String userPassword;
    private String userName;
    private Date userBirthday;
    private boolean userType;
    
    
    
}