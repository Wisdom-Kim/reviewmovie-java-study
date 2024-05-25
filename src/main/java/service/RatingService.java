package service;

import domain.Rating;
import dto.RatingDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.RatingRepository;


public class RatingService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_config");
    private EntityManager em = emf.createEntityManager();
    private RatingRepository ratingRepository;

    public void insertRating(RatingDTO ratingDTO) {
        Rating rating = ratingDTO.toEntity();
        ratingRepository.save(rating);
    }

    public Rating getRating(RatingDTO ratingDTO) {
        Rating rating = ratingDTO.toEntity();
        return ratingRepository.findOne(rating.getRatingId());
    }

//    public void updateRating(RatingDTO ratingDTO) {
//        Rating rating = ratingDTO.toEntity();
//
//    }

    public void deleteRating (RatingDTO ratingDTO) {
        Rating rating = ratingDTO.toEntity();
        ratingRepository.delete(rating);
    }

}
