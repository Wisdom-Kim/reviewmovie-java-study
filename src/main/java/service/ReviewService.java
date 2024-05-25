package service;

import domain.Rating;
import domain.Review;
import dto.RatingDTO;
import dto.ReviewDTO;
import repository.ReviewRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewService {

    private final ReviewRepository reviewRepository = ReviewRepository.getInstance();

    public void insertReview(ReviewDTO reviewDTO) {
        // 연관 객체의 생성은 ReviewDTO에서 다 맡긴다
        Review review = reviewDTO.toEntity();
        reviewRepository.save(review);
    }

    public void updateReview(ReviewDTO reviewDTO, String newContent, RatingDTO newRatingDTO) {
        // 엔티티를 조회한 후 변경된 값을 적용한다.
        Review review = reviewRepository.findOne(reviewDTO.getReviewId());
        review.setReviewContent(newContent);
        review.setRating(newRatingDTO.toEntity());

        reviewRepository.update(review);
    }

    public ReviewDTO getReview(int reviewId) {
        Review review = reviewRepository.findOne(reviewId);
        return ReviewDTO.fromEntity(review);
    }

    public List<ReviewDTO> getReviewListByMovieId(int movieId) {
        List<Review> reviewList = reviewRepository.findByMovieId(movieId);

        //Review 하나하나 다시 ReviewDTO로 변경
        return reviewList.stream().map(ReviewDTO::fromEntity).collect(Collectors.toList());
    }
}
