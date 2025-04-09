package com.dd.user.UserService.services;

import com.dd.user.UserService.entities.User;

import java.util.List;

public interface UserService {
    // Create User
    User saveUser(User user);

    // Get Users
    List<User> getAllUsers();

    //get User Based On user id.

    User getUserByUserId(String uId);

    //Delete user by Id
    void deleteUserById(String uId);

    //Update User by User id
    User updateUser(User updateUser);
}
