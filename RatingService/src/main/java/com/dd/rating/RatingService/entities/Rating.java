package com.dd.rating.RatingService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("user_ratings")// This is where we need define that entity as like in JPA(@Table --> @Document).
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private int ratingStar;//Out of 10
    private String feedBack;
}
