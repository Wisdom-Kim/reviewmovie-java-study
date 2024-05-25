package service;

import domain.User;
import dto.UserDTO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import util.JpaUtil;

public class UserService {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	
	public static boolean insertUser(UserDTO userDTO) {
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
	}

	public static UserDTO getUser(String accountId, String passwd) {
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
	}
}