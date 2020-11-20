package com.example.Rideshare.repository;

import com.example.Rideshare.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
    public Users findByUserID(String uuid);
    public List<Users> findByUsername(String username);
    public List<Users> findByEmail(String email);
}
