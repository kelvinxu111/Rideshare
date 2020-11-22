package com.example.Rideshare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.Rideshare.model.*;
import com.example.Rideshare.repository.*;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("usersService")
public class UserImplService implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User createUser(User user){
        User checkUser = findUserByUsername(user.getUserName());
        if (checkUser!=null){
            return null;
        }
        //Users lastUser = userRepository.findTopByOrderByIdDesc();
        user.setPassword(getPasswordHash("",user.getPassword()));
        userRepository.save(user);
        return user;
    }
    private String getPasswordHash(String salt, String plainText){
        return Hashing.sha256().hashString(salt + plainText, StandardCharsets.UTF_8).toString();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
