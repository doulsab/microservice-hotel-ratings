package com.dd.user.UserService.extranals;

import com.dd.user.UserService.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
// This client is used to send as declarative approach
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    // Declarative approach means calling the same API URL from that services.
    // Get the hotel by hotel id
    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
