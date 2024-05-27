package repository;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import util.JpaUtil;

public class UserRepository {
	private static UserRepository instance;
	private static final EntityManagerFactory emf =  JpaUtil.getEntityManagerFactory();

    private UserRepository() { }

    public static UserRepository getInstance() {
    	if (instance == null) {
    		instance = new UserRepository();
    	}
    	
    	return instance;
    }
    
    public boolean save(User user){
        EntityManager em = emf.createEntityManager();
        boolean insertResult = true;
        
        try {
        	em.getTransaction().begin();
        	em.merge(user);
        	em.getTransaction().commit();
        } catch(ConstraintViolationException e) {
        	em.getTransaction().rollback();
        	insertResult = false;
        
        } finally {        	
        	em.close();
        }
        
        return insertResult;
    }

    public User findOne(String accountId, String passwd){
        EntityManager em = emf.createEntityManager();
        
        User user = null;
        try {
        	String getUserJPQL = "SELECT u FROM User u WHERE u.userAccountId = :accountId AND u.userPassword = :passwd";
        	user = em.createQuery(getUserJPQL, User.class)
        			.setParameter("accountId", accountId)
        			.setParameter("passwd", passwd)
        			.getSingleResult();
        } catch(Exception e) {
        	e.printStackTrace();
        } finally {
        	em.close();
		}
        
        return user;
    }
    
    public List<User> findAll(){
        EntityManager em = emf.createEntityManager();
        
        List<User> userList =  em.createQuery("select u from User u", User.class).getResultList();
        em.close();
        
        return userList;
    }

}