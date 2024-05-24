package common.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	private static final String PERSISTENCE_UNIT = "jpa_config";
	
	public static EntityManagerFactory getEntityManagerFactory() {
		EntityManagerFactory emf = null;
		
		try {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return emf;
	}
	
	public static EntityManager getEntityManager() {
		EntityManagerFactory emf = getEntityManagerFactory();
		
		if(emf != null) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT); 
		}
		
		return emf.createEntityManager();
	}
	
	public static void emClose(EntityManager em) {
		if(em != null) {
			em.close();
		}
	}

	public static void emfClose(EntityManagerFactory emf) {
		if(emf != null) {
			emf.close();
		}
	}
	
}
