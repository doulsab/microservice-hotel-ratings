package com.dd.user.UserService.services.impl;

import com.dd.user.UserService.entities.Hotel;
import com.dd.user.UserService.entities.Rating;
import com.dd.user.UserService.entities.User;
import com.dd.user.UserService.exceptions.ResourceNotFoundException;
import com.dd.user.UserService.extranals.HotelService;
import com.dd.user.UserService.repositories.UserRepo;
import com.dd.user.UserService.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final RestTemplate restTemplate;
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final HotelService hotelService;

    String RATING_SERVICE_URL = "http://RATING-SERVICE/ratings/users/";
    String HOTEL_SERVICE_URL = "http://HOTEL-SERVICE/hotels/";

    @Override
    public User saveUser(User saveUser) {
        String userId = UUID.randomUUID().toString();
        saveUser.setUserId(userId);
        return userRepo.save(saveUser);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepo.findAll();
        // For each user, fetch ratings from external service (RATING-SERVICE) and update the user
        allUsers.forEach(user -> {
            // Get ratings by user ID
            Rating[] ratings = getRatingsByUserId(user.getUserId());
            List<Rating> listOfRatings = Arrays.asList(ratings);

            // Map each rating to include hotel details
            List<Rating> hotelAndRatingDetails = listOfRatings.stream()
                    .map(rating -> {
                        // Fetch the hotel for the rating

//                        1) by rest Template
//                        Hotel hotel = getHotelByHotelId(rating.getHotelId());

                        //  2) by feign webclient
                        Hotel hotel = hotelService.getHotel(rating.getHotelId());
                        if (hotel != null) {
                            rating.setHotel(hotel);
                        }
                        return rating;  // Return the updated rating
                    })
                    .toList();

            // Set the updated ratings to the user
            user.setRatings(hotelAndRatingDetails);
        });

        // Return the updated list of users
        return allUsers;
    }


    @Override
    public User getUserByUserId(String userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for given user id." + userId));
        // Call the rating services based on userId
        Rating[] userRatings = getRatingsByUserId(user.getUserId());
// Get all ratings as List
        List<Rating> ratings = Arrays.asList(userRatings);
        // Get hotels by passing the hotelId from userRatings
        List<Rating> rateWithHotel = ratings.stream().map(rating -> {
//           1) by restTemplate
           // Hotel hotel = getHotelByHotelId(rating.getHotelId());
//           2) by feign webclient
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).toList();
        logger.info("These are the ratings {} ", rateWithHotel);
        user.setRatings(rateWithHotel);
        return user;
    }

    @Override
    public void deleteUserById(String userId) {
        User user = getUserByUserId(userId);
        userRepo.delete(user);
    }

    @Override
    public User updateUser(User updateUser) {
        User foundUser = getUserByUserId(updateUser.getUserId());
        if (foundUser != null) {
            foundUser.setName(updateUser.getName());
            foundUser.setEmail(updateUser.getEmail());
            foundUser.setAbout(updateUser.getAbout());
            return userRepo.save(foundUser);
        } else {
            throw new ResourceNotFoundException("User not found for ID: " + updateUser.getUserId());
        }
    }

    /**
     * To get the ratings by user from external service name Called RATING-SERVICE.
     */
    private Rating[] getRatingsByUserId(String userId) {
        return restTemplate.getForObject(RATING_SERVICE_URL + userId, Rating[].class);
    }

    /**
     * To get the hotel by hotel id from ratings calling external service name Called HOTEL-SERVICE.
     */
    private Hotel getHotelByHotelId(String hotelId) {
        Hotel body = restTemplate.getForEntity(HOTEL_SERVICE_URL + hotelId, Hotel.class).getBody();
        logger.info("{} ", body);
        return body;
    }

}
