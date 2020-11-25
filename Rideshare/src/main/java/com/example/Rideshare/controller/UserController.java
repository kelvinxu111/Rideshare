package com.example.Rideshare.controller;

import com.example.Rideshare.model.User;
import com.google.common.hash.Hashing;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Rideshare.repository.UserRepository;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @GetMapping("/users/login")
    public ResponseEntity checkLoginUser(@RequestBody String username, String password){
        try{
            User validateUser = userRepository.findByUserName(username);
            String hashedPassword = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
            if (validateUser.getPassword()==hashedPassword){
                return new ResponseEntity<User>(validateUser,HttpStatus.OK);
            }
            else{
                return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/users")
    public ResponseEntity getAllUsers(@RequestParam(required = false) Map<String, String> queryParams) {
        try {
            List<User> users = new ArrayList<User>();

            if (queryParams == null) {
                userRepository.findAll().forEach(users::add);
            } else {
                if (queryParams.containsKey("userName")) {
                    users.add(userRepository.findByUserName(queryParams.get("userName")));
                }
            }

            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{userID}")
    public ResponseEntity getUserById(@PathVariable("userID") String userID) {
        try{
            User findUser = userRepository.findByUserID((UUID.fromString(userID)));
            if (findUser!=null){
                return new ResponseEntity<User>(findUser, HttpStatus.OK);
            }else{
                return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @PostMapping("/users/{userID}")
    public ResponseEntity activateUser(@PathVariable("userID") String userID){
        try{
            User findUser = userRepository.findByUserID((UUID.fromString(userID)));
            if (findUser!=null){
                findUser.setActivated(true);
                userRepository.save(findUser);
                return new ResponseEntity<User>(findUser, HttpStatus.OK);
            }else{
                return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            user.setPassword(Hashing.sha256().hashString(user.getPassword(), StandardCharsets.UTF_8).toString());
            user.setCreated(LocalDateTime.now());
            User u = userRepository.save(user);
            return new ResponseEntity<User>(u, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //TODO: figure out delete later, after other objects are modelled
    @DeleteMapping("/users/{userID}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("userID") String userID) {
        return null;
    }
}
