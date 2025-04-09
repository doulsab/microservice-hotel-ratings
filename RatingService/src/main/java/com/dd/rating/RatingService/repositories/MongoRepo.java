package com.dd.rating.RatingService.repositories;

import com.dd.rating.RatingService.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoRepo extends MongoRepository<Rating, String> {

    //Customer finder by using attribute name in UpperCamalCase syntax is that findBy<FiledName>
    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
