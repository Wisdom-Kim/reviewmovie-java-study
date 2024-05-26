package service;

import dto.UserDTO;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private final UserService userService = new UserService();

    @Test
    public void insertUser() {
        UserDTO userDTO = UserDTO.builder()
                .userAccountId("cocoa389")
                .userBirthday(new Date())
                .userName("김지혜")
                .userPassword("1234")
                .userType(false)
                .build();

        userService.insertUser(userDTO);
        UserDTO getUserDTO = UserService.getUser("cocoa389","1234");
        assertNotNull(getUserDTO);
    }

    @Test
    public void testGetUser() {

        UserDTO getUserDTO = UserService.getUser("cocoa389","1234");
        assertEquals(getUserDTO.getUserAccountId(),"cocoa389");
    }
}
