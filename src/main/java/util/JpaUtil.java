package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	private static final String PERSISTENCE_UNIT = "jpa_config";
	private static EntityManagerFactory emf = null;


	public static EntityManagerFactory getEntityManagerFactory() {
		try {
			if (emf != null) {
				emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emf;
	}


	public static EntityManager getEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}


	public static void emClose(EntityManager em) {
		if (em != null) {
			em.close();
		}
	}

	public static void emfClose() {
		if (emf != null) {
			emf.close();
		}
	}

	//싱글톤으로 변경
	private JpaUtil() {}
}
