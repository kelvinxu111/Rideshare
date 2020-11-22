package com.example.Rideshare.controller;

import com.example.Rideshare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Rideshare.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity getAllUsers(@RequestParam(required = false) Map<String, String> queryParams) {
        try {
            List<User> users = new ArrayList<User>();

            if (queryParams == null) {
                userRepository.findAll().forEach(users::add);
            } else {
                if (queryParams.containsKey("userName")) {
                    users.add(userRepository.findByUsername(queryParams.get("userName")));
                }
            }

            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{userID}")
    public ResponseEntity<User> getUserById(@PathVariable("userID") String userID) {
        return null;
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            User u = userRepository.save(user);
            return new ResponseEntity<User>(u, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{userID}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("userID") String userID) {
        return null;
    }
}
