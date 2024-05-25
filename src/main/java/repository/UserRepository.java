package repository;

import domain.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import util.JpaUtil;

import java.util.List;

public class UserRepository {

    private  UserRepository userRepository;
    private static final EntityManagerFactory emf =  JpaUtil.getEntityManagerFactory();
    private static final EntityManager em = emf.createEntityManager();

    public void save(User user){
        
        em.persist(user);
        em.close();
    }

    public User findOne(Long id){
        
        User user = em.find(User.class,id);
        em.close();
        return user;
    }
    public static List<User> findAll(){

        List<User> userList =  em.createQuery("select u from User u",User.class).getResultList();
        em.close();
        return userList;
    }

}
