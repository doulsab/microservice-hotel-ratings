package com.dd.hotel.HotelService.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    // Return dummy data as of now.
    // Get all staffs
    @GetMapping
    public ResponseEntity<List<String>> getStaffs() {
        List<String> listOfStaffs = Arrays.asList("Ryan", "Sandy", "Sunil", "Anand");
        return new ResponseEntity<>(listOfStaffs, HttpStatus.OK);
    }


}
