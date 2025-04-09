package com.dd.hotel.HotelService.services.impl;

import com.dd.hotel.HotelService.entities.Hotel;
import com.dd.hotel.HotelService.exceptions.ResourceNotFoundException;
import com.dd.hotel.HotelService.repositories.HotelRepo;
import com.dd.hotel.HotelService.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class HotelServiceImpl implements HotelService {
    // Injecting Hotel repository.
    private final HotelRepo hotelRepo;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Given hotel id is not present in Server!."));
    }

    @Override
    public void deleteHotelById(String hotelId) {
        Hotel hotel = getHotelById(hotelId);
        hotelRepo.delete(hotel);
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        Hotel foundHotel = getHotelById(hotel.getId());

        foundHotel.setAbout(hotel.getAbout());
        foundHotel.setName(hotel.getName());
        foundHotel.setLocation(hotel.getLocation());

        return hotelRepo.save(foundHotel);
    }
}
