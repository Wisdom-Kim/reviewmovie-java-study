package common.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_config");
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
	
	public static void closeEntityManagerFactory() {
		emf.close();
	}
	
/*
	public static EntityManager getEntityManager() {
		EntityManager em = emf.createEntityManager();
		
		return em;
	}
	
	public static EntityTransaction getEntityTransaction() {
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		return tx;
	}
*/
}
