package user.service;

import common.util.JpaUtil;
import domain.User;
import user.dao.UserDAO;

import jakarta.persistence.EntityManagerFactory;

public class UserService {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	
	public static boolean insertUser(User user) {
		return UserDAO.insertUser(emf, user);
	}
}