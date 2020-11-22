package com.example.Rideshare.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    //Not sure how to generate this
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "userId", columnDefinition = "varchar(255)")
    private UUID userID;

    @Column(name = "userName",nullable = false, unique = true)
    private String userName;

    @Column(name = "displayName",nullable = false, unique = true)
    private String displayName;

    @Column(name = "phoneNumber",nullable = false)
    private String phoneNumber;

    @Column(name = "email",nullable = false, unique = true)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "role",nullable = false)
    private String role;

    @Column(name = "licenseNumber",nullable = false, unique = true)
    private String licenseNumber;

    @OneToMany(mappedBy = "user")
    private List<Vehicle> vehicles;

    @Column(name = "created",nullable = false)
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    @Column(name = "deleted")
    private LocalDateTime deleted;

    @Column(name = "isActivated",nullable = false)
    private boolean isActivated;

    @Lob
    @Column(name = "profilePicture")
    private byte[] profilePicture;

    public User() {}

    public User(UUID userID, String username, String displayName, String phoneNumber, String email, String password, String role, String licenseNumber) {
        this.userID = userID;
        this.userName = username;
        this.displayName = displayName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.role = role;
        this.licenseNumber = licenseNumber;
        this.created = LocalDateTime.now();
        this.isActivated = false;
    }
}
