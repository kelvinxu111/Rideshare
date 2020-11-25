package com.example.Rideshare.repository;

import com.example.Rideshare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    public User findByUserID(UUID uuid);
    public User findByUserName(String username);
    public User findByEmail(String email);
    public void deleteByUserID(UUID uuid);
    //Don't think this is necessary, but will need to learn
    //To delete related entities
    @Modifying
    @Query("update User u set u.isActivated=?1 where u.userID=?2")
    public void setUserIsActivatedByUserID(boolean activated,UUID uuid);
}
