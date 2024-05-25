package service;


import domain.Movie;
import domain.Rating;
import domain.Review;
import domain.User;

import dto.MovieDTO;
import dto.RatingDTO;
import dto.ReviewDTO;
 import jakarta.persistence.EntityManager;
 import jakarta.persistence.EntityManagerFactory;
 import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
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
    private final ReviewRepository reviewRepository = ReviewRepository.getInstance();


    private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    public void insertReview(ReviewDTO reviewDTO) {
        //연관객체의 생성은 ReviewDTO에서 다 맡긴다
        Review review = reviewDTO.toEntity();
        reviewRepository.save(review);
    }

    public void updateReview(ReviewDTO reviewDTO,String newContent, RatingDTO newRatingDTO) {
        Review review = reviewDTO.toEntity();//원본
        Rating newRating = newRatingDTO.toEntity(); //수정된 평가
        review.setReviewContent(newContent);//리뷰 내용 수정
        review.setRating(newRating);//별점 수정

        reviewRepository.update(review);

    }

    public List<Review> getListByMovieId(int movieId) {
        EntityManager em = emf.createEntityManager();
        List<Review> reviewList = null;

        try {
            em.getTransaction().begin();
            TypedQuery<Review> query = em.createQuery("SELECT r from Review r WHERE r.movie.movieId=:movieId", Review.class);
            query.setParameter("movieId", movieId);
            reviewList = query.getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return reviewList;
    }
}