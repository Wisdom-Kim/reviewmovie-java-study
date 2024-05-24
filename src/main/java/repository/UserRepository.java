package repository;

import domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import util.JpaUtil;

import java.util.List;

public class UserRepository {

    private  UserRepository userRepository;
    private static final EntityManagerFactory emf =  JpaUtil.getEntityManagerFactory();
    private static final EntityManager em = emf.createEntityManager();

    public void save(User user){
        //리뷰 저장
        em.persist(user);
        em.close();
    }

    public User findOne(Long id){
        //리뷰
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
