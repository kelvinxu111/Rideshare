package com.example.Rideshare.services;
import com.example.Rideshare.model.*;
import java.util.List;
import java.util.UUID;

public interface usersService {
    public Users findUserById(UUID id);
    public Users findUserByUsername(String username);
    public Users findByUsername(String username);
    public Users findByEmail(String email);
    public List<Users> findAll();
    public Users createUser(Users user);
}
