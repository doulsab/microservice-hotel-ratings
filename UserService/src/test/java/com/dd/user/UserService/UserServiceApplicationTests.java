package com.dd.user.UserService;

import com.dd.user.UserService.entities.Rating;
import com.dd.user.UserService.extranals.RatingService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    // Test the Create RATING-SERVICE
    // This testing the to create the Rating from user service.
    @Autowired
    private RatingService ratingService;

//    @Test
//    public void createRating() {
//        Rating rating = Rating.builder()
//                .userId("636ce174-6ec1-422c-aa17-83ab1f14ca05")
//                .ratingStar(8)
//                .hotelId("e2427c9a-48e6-4580-af55-e02f50321fa0")
//                .feedBack("This is testing from Test class")
//                .build();
//        ResponseEntity<Rating> savedRating =  ratingService.createRating(rating);
//        System.out.println("Rating Saved"+ savedRating.getBody());
//    }
}
