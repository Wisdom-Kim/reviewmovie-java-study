package repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import domain.Movie;
import util.JpaUtil;

public class MovieRepository {
    //김지혜 수정 사항
    //
    private static MovieRepository movieRepository;
    private static final EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    private MovieRepository() {
    }

    public static MovieRepository getInstance() {
        if (movieRepository == null) {
            movieRepository = new MovieRepository();
        }
        return movieRepository;
    }

    //싱글톤으로 관리하기 위해 public 제거
    //또, em을 CRUD 작업마다 새로 만들어주어야 꼬일 위험이 적어서, 일단 주석처리하고 싱글톤으로 만들게요
//    public MovieRepository(EntityManager em) {
//        this.em = em;
//    }

    public Movie findById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Movie.class, id);
    }

    public List<Movie> searchMoviesByTitle(String title) {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT m FROM Movie m WHERE m.movieTitle LIKE :title"; //Movie 객체의 필드명으로 수정
        TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }

    public List<Movie> findMoviesByRatingDesc() {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT m FROM Movie m "
                    + "LEFT JOIN m.reviewList r "
                    + "LEFT JOIN r.ratingList rat "
                    + "GROUP BY m "
                    + "ORDER BY AVG(rat.ratingScore) DESC";

        TypedQuery<Movie> query = em.createQuery(jpql, Movie.class);
        return query.getResultList();
    }
}