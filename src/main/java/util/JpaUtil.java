package util;

<<<<<<< Updated upstream
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	// persistence.xml 내의 persistence-unit tag name
	 private static final String PERSISTENCE_UNIT = "jpa_config";

	    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

	    public static EntityManagerFactory getEntityManagerFactory() {
	        return emf;
	    }

	    public static EntityManager getEntityManager() {
	        return getEntityManagerFactory().createEntityManager();
	    }

	    public static void closeEntityManager(EntityManager em) {
	        if (em != null) {
	            em.close();
	        }
	    }

	    public static void closeEntityManagerFactory() {
	        if (emf != null) {
	            emf.close();
	        }
	    }

	    // 싱글톤으로 변경
	    private JpaUtil() {}
=======
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
	// persistence.xml 내의 persistence-unit tag name
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_config");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public static void closeEntityManager(EntityManager em) {
        if (em != null) {
            em.close();
        }
    }

    public static void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
        }
    }

    // 싱글톤으로 변경
    private JpaUtil() {}
>>>>>>> Stashed changes
}