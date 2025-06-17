package com.dd.rating.RatingService.restcontrollers;

import com.dd.rating.RatingService.entities.Rating;
import com.dd.rating.RatingService.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ratings")
public class RatingController {
    //Injecting the Service using constructor
    private final RatingService ratingService;

    // Save ratings
    @PostMapping
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
        return new ResponseEntity<>(ratingService.createRating(rating), HttpStatus.CREATED);
    }

    // Get all ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating() {
        return new ResponseEntity<>(ratingService.getAllRatings(), HttpStatus.OK);
    }

    // Get Ratings by userId
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        return new ResponseEntity<>(ratingService.getRatingsByUserId(userId), HttpStatus.OK);
    }// Get Ratings by userId

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId) {
        return new ResponseEntity<>(ratingService.getRatingsByHotelId(hotelId), HttpStatus.OK);
    }

    // Update rating id
    @PutMapping("/{ratingId}")
    ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating updateRating) {
        return new ResponseEntity<>(ratingService.updateRating(ratingId, updateRating), HttpStatus.OK);
    }

    // Delete Rating
    @DeleteMapping("/{ratingId}")
    void deleteRating(@PathVariable String ratingId) {
        ratingService.deleteRatingByRatingId(ratingId);
    }
}
