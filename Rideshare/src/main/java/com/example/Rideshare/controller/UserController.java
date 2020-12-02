package com.example.Rideshare.controller;

import com.example.Rideshare.model.User;
import com.example.Rideshare.services.UserImplService;
import com.google.common.hash.Hashing;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Rideshare.repository.UserRepository;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
public class UserController {

//    @Autowired
//    UserRepository userRepository;
    UserImplService userImplService;

    @GetMapping("/users/login")
    public ResponseEntity checkLoginUser(@RequestBody String username, String password) {
        try {
            if (!(username instanceof String) || !(password instanceof String))
                return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
            User validateUser = userImplService.checkLoginUser(username, password);
            if (validateUser != null) {
                return new ResponseEntity<User>(validateUser, HttpStatus.OK);
            } else {
                return new ResponseEntity(null, HttpStatus.FORBIDDEN);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users")
    public ResponseEntity getAllUsers(@RequestParam(required = false) Map<String, String> queryParams) {
        try {
            List<User> users = new ArrayList<User>();

            if (queryParams == null) {
                userImplService.findAll().forEach(users::add);
            } else {
                if (queryParams.containsKey("userName")) {
                    users.add(userImplService.findUserByUserName(queryParams.get("userName")));
                }
            }
            if (users.size() == 0) return new ResponseEntity(null, HttpStatus.NO_CONTENT);
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{userID}")
    public ResponseEntity getUserById(@PathVariable("userID") String userID) {
        try {
            //Unsure if it's a type problem
            User findUser = userImplService.findUserById((UUID.fromString(userID)));
            if (findUser != null) {
                return new ResponseEntity<User>(findUser, HttpStatus.OK);
            } else {
                return new ResponseEntity(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PostMapping("/users/{userID}")
    public ResponseEntity activateUser(@PathVariable("userID") String userID) {
        try {
            User findUser = userImplService.activateUser(userID);
            if (findUser != null) {
                return new ResponseEntity<User>(findUser, HttpStatus.OK);
            } else {
                return new ResponseEntity(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            //TODO: lookup more status codes for different situations
            User u = userImplService.createUser(user);
            if (u == null) return new ResponseEntity(null, HttpStatus.CONFLICT);
            return new ResponseEntity<User>(u, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO: figure out delete later, after other objects are modelled
    //Use 204(No Contents), 202, 203?
    @DeleteMapping("/users/{userID}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("userID") String userID) {
        return null;
    }
}
