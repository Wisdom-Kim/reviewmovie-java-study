package service;

import domain.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import util.JpaUtil;

public class UserService {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	
	public static boolean insertUser(User user) {
    	boolean insertResult = true;
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
    	
    	tx.begin();
		try {
			// 회원 등록
			em.persist(user);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			insertResult = false;
		} finally {
			em.close();
		}
				
		return insertResult;
    }
}