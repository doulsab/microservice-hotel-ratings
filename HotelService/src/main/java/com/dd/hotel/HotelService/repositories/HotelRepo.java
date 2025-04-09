package com.dd.hotel.HotelService.repositories;

import com.dd.hotel.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, String> {
}
