package com.dd.user.UserService.extranals;


import com.dd.user.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    // Create Rating
    @PostMapping("/ratings")
    ResponseEntity<Rating> createRating(Rating storeRating);

    //Update Rating
    @PutMapping("/ratings/{ratingId}")
    ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating updateRating);
    // Delete Rating
    @DeleteMapping("/ratings/{ratingId}")
    void deleteRating(@PathVariable String ratingId);

    // Get rating for the User
    @GetMapping("/ratings/users/{userId}")
    ResponseEntity<Rating[]> getRatingByUserId(@PathVariable("userId") String userId);
}
