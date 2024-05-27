package repository;

import java.util.List;

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
    
    public void save(User user){
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

    public User findOne(String accountId, String passwd){
        EntityManager em = emf.createEntityManager();
        
        String getUserJPQL = "SELECT u FROM User u WHERE u.userAccountId = :accountId AND u.userPassword = :passwd";
        User user = em.createQuery(getUserJPQL, User.class)
                			.setParameter("accountId", accountId)
                			.setParameter("passwd", passwd)
                			.getSingleResult();
        em.close();
        
        return user;
    }
    
    public List<User> findAll(){
        EntityManager em = emf.createEntityManager();
        
        List<User> userList =  em.createQuery("select u from User u", User.class).getResultList();
        em.close();
        
        return userList;
    }

}
