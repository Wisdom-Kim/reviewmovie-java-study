package service;

import domain.Movie;
import domain.Review;
import domain.User;
import dto.ReviewDTO;
import dto.UserDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import repository.UserRepository;

public class UserService {
	UserRepository userRepository = UserRepository.getInstance();
	private static UserService instance;
	
	private UserService() {}
	
	public static UserService getInstance() {
		if (instance == null) {
        	instance = new UserService();
        }    
        return instance;
    }
	
	public boolean insertUser(UserDTO userDTO) {
		User user = userDTO.toEntity();

		return userRepository.save(user);
	}

	public UserDTO getUser(String accountId, String passwd) {
        User user = userRepository.findOne(accountId, passwd);
        
        if (user == null) {
            throw new NullPointerException("회원 정보가 없습니다.");
        }
        
		return UserDTO.fromEntity(user);
	}


	public User getUserById(int movieId) {
		return userRepository.findById(movieId);
	}
}