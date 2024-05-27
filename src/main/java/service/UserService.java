package service;

import domain.User;
import dto.UserDTO;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
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
	
	public void insertUser(UserDTO userDTO) {
		User user = userDTO.toEntity();

		userRepository.save(user);
	}

	public UserDTO getUser(String accountId, String passwd) {
        User user = userRepository.findOne(accountId, passwd);
        
        if (user == null) {
            throw new NullPointerException("회원 정보가 없습니다.");
        }
        
		return UserDTO.fromEntity(user);
	}
}