package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	// persistence.xml 내의 persistence-unit tag name
	private static final String PERSISTENCE_UNIT = "jpa_config";
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	
	public static EntityManagerFactory getEntityManagerFactory() {
		
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
