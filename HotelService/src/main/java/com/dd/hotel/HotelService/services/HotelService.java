package com.dd.hotel.HotelService.services;

import com.dd.hotel.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {
    // Create Hotel
    Hotel createHotel(Hotel hotel);

    //Get all hotels
    List<Hotel> getAllHotels();

    //Get Hotel by Id
    Hotel getHotelById(String hotelId);

    //Delete hotel by Id
    void deleteHotelById(String hotelId);

    // update Hotel by Id
    Hotel updateHotel(Hotel hotel);
}
