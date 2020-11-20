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
public class Users {

    @Id
    //Not sure how to generate this
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "userID", columnDefinition = "varchar(255)")
    private UUID userID;

    @Column(name = "username")
    private String username;

    @Column(name = "displayName")
    private String displayName;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "licenseNumber")
    private String licenseNumber;

    @OneToMany(mappedBy = "user")
    private List<Vehicles> vehicles;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    @Column(name = "deleted")
    private LocalDateTime deleted;

    @Column(name = "isActivated")
    private boolean isActivated;

    @Lob
    @Column(name = "profilePicture")
    private byte[] profilePicture;

    public Users() {}

    public Users(UUID userID, String username, String displayName, String phoneNumber, String email, String password, String role, String licenseNumber) {
        this.userID = userID;
        this.username = username;
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
