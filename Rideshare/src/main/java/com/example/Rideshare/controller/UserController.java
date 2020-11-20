package com.example.Rideshare.controller;

import com.example.Rideshare.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
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
    public ResponseEntity<List<Users>> getAllUsers(@RequestParam(required = false) Map<String, String> queryParams) {
        try {
            List<Users> users = new ArrayList<Users>();

            if (queryParams == null) {
                userRepository.findAll().forEach(users::add);
            } else {
                if (queryParams.containsKey("username")) {
                    userRepository.findByUsername(queryParams.get("username")).forEach(users::add);
                }
            }

            return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{userID}")
    public ResponseEntity<Users> getUserById(@PathVariable("userID") String userID) {
        return null;
    }

    @PostMapping("/users")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        try {
            Users u = userRepository.save(user);
            return new ResponseEntity<Users>(u, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/users/{userID}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("userID") String userID) {
        return null;
    }
}
