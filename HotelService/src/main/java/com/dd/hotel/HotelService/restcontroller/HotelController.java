package com.dd.hotel.HotelService.restcontroller;

import com.dd.hotel.HotelService.entities.Hotel;
import com.dd.hotel.HotelService.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {
    // Injecting the Hotel Service.
    private final HotelService hotelService;

    // Create Hotel
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
    }

    // Get all hotels
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return new ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.OK);
    }

    // Get hotel by Id
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        return new ResponseEntity<>(hotelService.getHotelById(hotelId), HttpStatus.OK);
    }

    //Update hotel
    @PutMapping
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.updateHotel(hotel), HttpStatus.CREATED);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<String> deleteHotelById(@PathVariable String hotelId) {
        hotelService.deleteHotelById(hotelId);
        return new ResponseEntity<>("Hotel delete success", HttpStatus.OK);
    }


}
