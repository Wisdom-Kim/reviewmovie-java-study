package service;

import domain.Movie;
import domain.Rating;
import domain.Review;
import domain.User;
import dto.RatingDTO;
import dto.ReviewDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import repository.MovieRepository;
import repository.ReviewRepository;
import repository.RatingRepository;
import repository.UserRepository;
import util.JpaUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewService {

    private static final ReviewService reviewService = new ReviewService();
    private final ReviewRepository reviewRepository = ReviewRepository.getInstance();
    private final RatingRepository ratingRepository = RatingRepository.getInstance();
    private final MovieRepository movieRepository = MovieRepository.getInstance();
    private final UserRepository userRepository = UserRepository.getInstance();

    EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
    public static ReviewService getInstance() {
        return reviewService;
    }

    private ReviewService(){};

    public void insertReview(ReviewDTO reviewDTO) {
        reviewRepository.save(reviewDTO.toEntity());
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