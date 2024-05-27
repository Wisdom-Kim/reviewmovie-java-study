package service;

import domain.Rating;
import domain.Review;
import dto.RatingDTO;
import dto.ReviewDTO;
import repository.ReviewRepository;
import repository.RatingRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewService {

    private static final ReviewService reviewService = new ReviewService();
    private final ReviewRepository reviewRepository = ReviewRepository.getInstance();
    private final RatingRepository ratingRepository = RatingRepository.getInstance();

    public static ReviewService getInstance() {
        return reviewService;
    }

    private ReviewService(){};

    public void insertReview(ReviewDTO reviewDTO, RatingDTO ratingDTO) {
        // Rating을 먼저 생성하고 저장
        Rating rating = ratingDTO.toEntity();
        ratingRepository.save(rating);

        // 생성된 Rating의 ID를 ReviewDTO에 설정
        reviewDTO.setRatingId(rating.getRatingId());

        // ReviewDTO를 이용해 Review를 생성하고 저장
        Review review = reviewDTO.toEntity();
        review.setRating(rating);  // Rating을 Review에 매핑

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

    public  List<ReviewDTO> getReviewsByMovieId(int movieId) {
    //최대 cnt개 만큼 movieId의 리뷰를 가져옴 //현재 cnt는 없앰
        List<Review> reviews = reviewRepository.findManyByMovieId(movieId);
        return reviews.stream()
                .map(ReviewDTO::fromEntity)
                .collect(Collectors.toList());

    }
}
