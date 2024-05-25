package service;


import domain.Movie;
import domain.Rating;
import domain.Review;
import domain.User;

import dto.RatingDTO;
import dto.ReviewDTO;
 import jakarta.persistence.EntityManager;
 import jakarta.persistence.EntityManagerFactory;
 import jakarta.persistence.EntityTransaction;
import repository.MovieRepository;
import repository.RatingRepository;
import repository.ReviewRepository;
import repository.UserRepository;
import util.JpaUtil;
import java.util.List;


public class ReviewService {

    private final RatingRepository ratingRepository = RatingRepository.getInstance();
    private final MovieRepository movieRepository = MovieRepository.getInstance();
    private final UserRepository userRepository = UserRepository.getInstance();


    private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    public void insertReview(ReviewDTO reviewDTO, RatingDTO ratingDTO) {
        //reviewDTO에서 전송받은 정보들을 바탕으로 리뷰를 생성하고, 넣어주자
        Rating rating = ratingDTO.toEntity();
        reviewDTO.toEntity();
    }

    public void updateReview(int reviewId, ReviewDTO reviewDTO) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Review review = em.find(Review.class, reviewId);
            if (review != null) {
//                Rating newRating = em.find(Rating.class, reviewDTO.getRating());

                // DTO의 toEntity 메서드를 사용하여 변경된 내용을 반영한 새로운 Review 객체 생성
                Review updatedReview = reviewDTO.toEntity();

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

//    public List<Review> getListByMovieId(int movieId) {
//        EntityManager em = emf.createEntityManager();
//        ReviewRepository reviewRepository;
//        List<Review> reviewList = null;
//
//        try {
//            reviewList = reviewRepository.getListByMovieId(movieId);
//        } finally {
//            em.close();
//        }
//        return reviewList;
//    }
}