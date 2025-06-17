package com.dd.rating.RatingService.services.impl;

import com.dd.rating.RatingService.entities.Rating;
import com.dd.rating.RatingService.exeptions.RatingNotFoundException;
import com.dd.rating.RatingService.repositories.MongoRepo;
import com.dd.rating.RatingService.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    // Mongo repository inject using constructor injection
    private final MongoRepo mongoRepo;

    @Override
    public Rating createRating(Rating rating) {
        return mongoRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return mongoRepo.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return mongoRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return mongoRepo.findByHotelId(hotelId);
    }

    @Override
    public void deleteRatingByRatingId(String ratingId) {
        Rating existingRating = mongoRepo.findById(ratingId).orElseThrow(() ->
                new RatingNotFoundException("Rating not exist for this Id" + ratingId));
        mongoRepo.deleteById(ratingId);
    }

    @Override
    public Rating updateRating(String ratingId, Rating updateRating) {
        Rating existingRating = mongoRepo.findById(ratingId).orElseThrow(() ->
                new RatingNotFoundException("Rating not exist for this Id" + ratingId));
        existingRating.setRatingStar(updateRating.getRatingStar());
        existingRating.setFeedBack(updateRating.getFeedBack());
        existingRating.setHotelId(updateRating.getHotelId());
        existingRating.setUserId(updateRating.getUserId());
        return mongoRepo.save(existingRating);
    }
}
