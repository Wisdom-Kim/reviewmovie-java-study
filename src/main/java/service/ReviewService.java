package service;

import domain.Review;
import dto.MovieDTO;
import dto.ReviewDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import repository.ReviewRepository;
import repository.RatingRepository;
import util.JpaUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewService {

    private EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    private final ReviewRepository reviewRepository = ReviewRepository.getInstance();
    private final RatingRepository ratingRepository = RatingRepository.getInstance();

    public void insertReview(ReviewDTO reviewDTO) {
        Review review = reviewDTO.toEntity();

        // Rating을 먼저 저장
        if (review.getRating() != null) {
            ratingRepository.save(review.getRating());
        }

        reviewRepository.save(review);
    }

    public ReviewDTO getReview(int reviewId) {
        Review review = reviewRepository.findOneWithDetails(reviewId);
        if (review == null) {
            throw new NullPointerException("Review not found");
        }
        return ReviewDTO.fromEntity(review);
    }

    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(ReviewDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteReview(int reviewId) {
        Review review = reviewRepository.findOne(reviewId);
        if (review != null) {
            reviewRepository.delete(review);
        }
    }
}
