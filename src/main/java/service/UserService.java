package service;

import domain.User;
import dto.UserDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import repository.UserRepository;
import util.JpaUtil;

public class UserService {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	private final static UserRepository userRepository = UserRepository.getInstance();
	
	public static boolean insertUser(UserDTO userDTO) {
		User user = userDTO.toEntity();
		userRepository.save(user);
        
		return true;
		
		/*
		boolean insertResult = true;
	    EntityManager em = null;
	    EntityTransaction tx = null;

	    try {
	        em = emf.createEntityManager();
	        tx = em.getTransaction();
	        tx.begin();

	        User user = userDTO.toEntity(); // UserDTO를 User 엔티티로 변환
	        em.persist(user);
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        insertResult = false;
	        e.printStackTrace(); 
	    } finally {
	        if (em != null) {
	            em.close(); 
	        }
	    }

	    return insertResult;
	    */
	}

	public static UserDTO getUser(String accountId, String passwd) {
        User user = UserRepository.findOne(accountId, passwd);
        
        if (user == null) {
            throw new NullPointerException("회원 정보가 없습니다.");
        }
        
		return UserDTO.fromEntity(user);
		/*
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
    	
		UserDTO userDTO = null;
		
    	tx.begin();
		try {
			// 회원 조회
			String getUserJPQL = "SELECT u FROM User u WHERE u.userAccountId = :accountId AND u.userPassword = :passwd";
	        User user = em.createQuery(getUserJPQL, User.class)
	                			.setParameter("accountId", accountId)
	                			.setParameter("passwd", passwd)
	                			.getSingleResult();

	        tx.commit();
	        userDTO = UserDTO.fromEntity(user);
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }

	    return userDTO;
	    */
	}
}