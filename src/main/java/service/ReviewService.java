package service;


import domain.Movie;
import domain.Rating;
import domain.Review;
import domain.User;

import dto.ReviewDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.NoArgsConstructor;
import repository.MovieRepository;
import repository.ReviewRepository;
import repository.UserRepository;
import util.JpaUtil;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class ReviewService {

    private static MovieRepository movieRepository;
    private static ReviewRepository reviewRepository;
    private static UserRepository userRepository;

    private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    public void insertReview(int reviewId, int movieId, int userId, String reviewContent, int ratingId) {

        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        ReviewRepository reviewRepository = new ReviewRepository(em);

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

            reviewRepository.save(review);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void updateReview(int reviewId, ReviewDTO reviewDTO) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Review review = em.find(Review.class, reviewId);
            if (review != null) {
                Rating newRating = em.find(Rating.class, reviewDTO.getRating());

                // DTO의 toEntity 메서드를 사용하여 변경된 내용을 반영한 새로운 Review 객체 생성
                Review updatedReview = reviewDTO.toEntity(review, newRating);

                em.merge(updatedReview);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Review> getListByMovieId(int movieId) {
        EntityManager em = emf.createEntityManager();
        ReviewRepository reviewRepository = new ReviewRepository(em);
        List<Review> reviewList = null;

        try {
            reviewList = reviewRepository.getListByMovieId(movieId);
        } finally {
            em.close();
        }
        return reviewList;
    }
}