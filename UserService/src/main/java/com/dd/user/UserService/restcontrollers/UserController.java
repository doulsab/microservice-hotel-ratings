package com.dd.user.UserService.restcontrollers;

import com.dd.user.UserService.entities.User;
import com.dd.user.UserService.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    //Service inject
    private final UserService userService;

    // Save User method
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User saveUser) {
        return new ResponseEntity<>(userService.saveUser(saveUser), HttpStatus.CREATED);
    }

    // Get All users
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    //Get user by userId
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        return new ResponseEntity<>(userService.getUserByUserId(userId), HttpStatus.OK);
    }

    //Delete User
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable String userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully! " + userId);
    }

    //Update User
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User udpateUser) {
        return new ResponseEntity<>(userService.updateUser(udpateUser), HttpStatus.CREATED);
    }


}
