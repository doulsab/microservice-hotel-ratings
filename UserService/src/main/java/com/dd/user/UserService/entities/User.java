package com.dd.user.UserService.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "micro-users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "ID")
    private String userId;
    @Column(name = "NAME", length = 25)
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ABOUT")
    private String about;

    @Transient// No need to create the column name called rations in DB.
    private List<Rating> ratings =  new ArrayList<>();


}
