package com.dd.user.UserService.entities;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int ratingStar;//Out of 10
    private String feedBack;
    @Transient// No need to create the column name called rations in DB.
    private Hotel hotel;
}
