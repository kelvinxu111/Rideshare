package com.example.Rideshare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.Rideshare.model.*;
import com.example.Rideshare.repository.*;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("usersService")
public class UserImplService implements UserService {
    //TODO: Move controller logic to here
    //TODO: learn lambda search functions
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(UUID id) {
        return userRepository.findByUserID(id);
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User createUser(User user){
        User checkUser = findUserByUserName(user.getUserName());
        if (checkUser!=null){
            return null;
        }
        user.setSalt(LocalDateTime.now().toString());
        user.setPassword(Hashing.sha256().hashString(user.getSalt()+user.getPassword(), StandardCharsets.UTF_8).toString());
        user.setCreated(LocalDateTime.now());
        userRepository.save(user);
        return user;
    }
    private String getPasswordHash(String salt, String plainText){
        return Hashing.sha256().hashString(salt + plainText, StandardCharsets.UTF_8).toString();
    }
    public User checkLoginUser(String username,String password){
        User validateUser = userRepository.findByUserName(username);
        String salt = validateUser.getSalt();
        String hashedPassword = Hashing.sha256().hashString(salt+password, StandardCharsets.UTF_8).toString();
        if (validateUser.getPassword()==hashedPassword){
            return validateUser;
        }else{
            return null;
        }
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User activateUser(String userID){
        User findUser = userRepository.findByUserID((UUID.fromString(userID)));
        if (findUser!=null) {
            findUser.setActivated(true);
            userRepository.save(findUser);
            return findUser;
        }else{
            return null;
        }
    }
}
