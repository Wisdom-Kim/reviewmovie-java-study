package repository;

import domain.Rating;
import domain.Review;
import dto.RatingDTO;
import dto.ReviewDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ReviewRepository {
;
    private static ReviewRepository reviewRepository;

    private EntityManager em;
    //service 계층에서 em을 생성시키고, repository에 넣어주자
    public void save(Review review) {
        try {
            em.getTransaction().begin();
            em.persist(review);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Review findById(Long id) {
        try {
            return em.find(Review.class, id);
        } finally {
            em.close();
        }
    }

    public List<Review> findAll() {
        try {
            return em.createQuery("select r from Review r", Review.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void updateById(ReviewDTO reviewDTO, RatingDTO ratingDTO,String newContent) {
        //리뷰, 평점 객체를 가져오기 위한 DTO, 수정할 리뷰 내용

        //엔터티에 setter를 사용해서 수정하는 것은 보안상 좋지 않음
        //DTO의 setter를 이용할 것

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Review review = em.find(Review.class, reviewDTO.getReviewId()); //수정될 개체


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    //리뷰 삭제
    public void deleteById(Long id) {
        try {
            em.getTransaction().begin();
            Review review = em.find(Review.class, id);
            if (review != null) {
                em.remove(review);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    //영화 ID로 리뷰들 가져오기
    public List<Review> getListByMovieId(int movieId) {
        EntityTransaction tx = em.getTransaction();

        List<Review> reviewList = null;

        try {
            tx.begin();
            String query ="SELECT r FROM Review r WHERE r.movie.movieId = :movieId";
            TypedQuery<Review> findByMovieIdQuery= em.createQuery(query, Review.class)
                    .setParameter("movieId", movieId);

            reviewList = findByMovieIdQuery.getResultList();
            System.out.println("(ReviewRepository)reviewList.size() :" +reviewList.size());
            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        return reviewList;

    }
}
