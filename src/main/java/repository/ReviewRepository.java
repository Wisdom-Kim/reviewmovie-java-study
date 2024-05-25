package repository;

import domain.Movie;
import domain.Rating;
import domain.Review;
import domain.User;
import dto.ReviewDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import util.JpaUtil;

import java.util.List;

@AllArgsConstructor
public class ReviewRepository {
;
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

    public void insertReview(int reviewId, int movieId, int userId, String reviewContent, int ratingId){
        //삽입은 바로 DTO 없이 반영가능
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Movie movie = em.find(Movie.class, movieId);
            User user = em.find(User.class, userId);
            Rating rating = em.find(Rating.class, ratingId);

            Review review = Review.builder()
                    .reviewId(reviewId)
                    .movie(movie)
                    .user(user)
                    .rating(rating)
                    .reviewContent(reviewContent)
                    .build();
            //ReviewDate는 자동생성하게 만들었음

            em.persist(review);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
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

    public void updateById(int reviewId, ReviewDTO reviewDTO) {
        //엔터티에 setter를 사용해서 수정하는 것은 보안상 좋지 않음
        //DTO의 setter를 이용할 것

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Review review = em.find(Review.class, reviewId); //수정될 개체
            if (review != null) {
                Rating newRating = em.find(Rating.class, reviewDTO.getRating()); //수정할(덮어쓰기할) 리뷰

                // 새로운 Review 객체를 빌드하여 변경된 내용 반영
                Review updatedReview = Review.builder()
                        .reviewId(review.getReviewId())
                        .movie(review.getMovie())
                        .user(review.getUser())
                        .reviewContent(reviewDTO.getReviewContent())
                        .rating(newRating)
                        .reviewDate(review.getReviewDate()) // 생성 시 자동으로 설정되는 필드이므로 유지!
                        .build();

                em.merge(updatedReview); //덮어쓰기
            }

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
