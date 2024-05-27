package repository;

import java.util.List;

import domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import util.JpaUtil;

public class UserRepository {
    //김지혜 수정사항
    // 1. 싱글톤으로 변환
    // 2. CRUD작업마다 em새로 만들어주기

    private static UserRepository userRepository;
    private static final EntityManagerFactory emf =  JpaUtil.getEntityManagerFactory();

    public static UserRepository getInstance() {
        return userRepository;
    }


    private UserRepository() {
    }

//    public static UserRepository getInstance() {
//        if (userRepository == null) {
//            userRepository = new UserRepository();
//        }
//        return userRepository;
//    }
    
    public static void save(User user){
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public static User findOne(String accountId, String passwd){
        EntityManager em = emf.createEntityManager();
        
        String getUserJPQL = "SELECT u FROM User u WHERE u.userAccountId = :accountId AND u.userPassword = :passwd";
        User user = em.createQuery(getUserJPQL, User.class)
                			.setParameter("accountId", accountId)
                			.setParameter("passwd", passwd)
                			.getSingleResult();
        em.close();
        
        return user;
    }
    
    public static List<User> findAll(){
        EntityManager em = emf.createEntityManager();
        List<User> userList =  em.createQuery("select u from User u",User.class).getResultList();
        em.close();
        return userList;
    }

}
