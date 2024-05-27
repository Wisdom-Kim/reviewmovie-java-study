package service;

import domain.User;
import dto.UserDTO;
import repository.UserRepository;

public class UserService {

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

        UserRepository.save(user);
	}

	public UserDTO getUser(String accountId, String passwd) {
        User user = UserRepository.findOne(accountId, passwd);
        
        if (user == null) {
            throw new NullPointerException("회원 정보가 없습니다.");
        }
        
		return UserDTO.fromEntity(user);
	}
}