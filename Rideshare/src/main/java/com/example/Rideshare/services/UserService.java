package com.example.Rideshare.services;
import com.example.Rideshare.model.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    public Optional<User> findUserById(UUID id);
    public User findUserByUserName(String username);
    public User findByUsername(String username);
    public User findByEmail(String email);
    public List<User> findAll();
    public User createUser(User user);
}
