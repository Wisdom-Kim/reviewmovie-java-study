package service;

import domain.User;
import dto.RatingDTO;
import dto.UserDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.JpaUtil;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

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
