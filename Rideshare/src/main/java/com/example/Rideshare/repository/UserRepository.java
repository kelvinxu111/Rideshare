package com.example.Rideshare.repository;

import com.example.Rideshare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    public Optional<User> findByUserID(UUID uuid);
    public User findByUsername(String username);
    public User findByEmail(String email);
}
