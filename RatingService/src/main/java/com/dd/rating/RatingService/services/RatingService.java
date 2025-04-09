package com.dd.rating.RatingService.services;

import com.dd.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {
    // Create Rating
    Rating createRating(Rating rating);

    // Get all ratings
    List<Rating> getAllRatings();

    // Get rating by userId
    List<Rating> getRatingsByUserId(String userId);

    // Get rating by hotelId
    List<Rating> getRatingsByHotelId(String hotelId);
}
