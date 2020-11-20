package com.example.Rideshare.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import java.util.List;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class Users {
    @Id
    //Not sure how to generate this
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "userId", columnDefinition = "varchar(255)")
    private UUID UserID;
    @Column(name = "userName", nullable = false)
    private String Username;
    @Column(name = "displayName", nullable = false)
    private String DisplayName;
    @Column(name = "phoneNumber", nullable = false)
    private String PhoneNumber;
    @Column(name = "email", nullable = false)
    private String Email;
    @Column(name = "password", nullable = false)
    private String Password;
    @Column(name = "role", nullable = false)
    private String Role;
    @Column(name = "licenseNumber", nullable = false)
    private String LicenseNumber;
    @OneToMany(mappedBy = "user")
    private List<Vehicles> vehicles;
    @Column(name = "created", nullable = false)
    private LocalDateTime Created;
    @Column(name = "updated")
    private LocalDateTime Updated;
    @Column(name = "deleted")
    private LocalDateTime Deleted;
    @Column(name = "isActivated", nullable = false)
    private boolean IsActivated;
    @Lob
    @Column(name = "profilePicture")
    private byte[] ProfilePicture;
    public Users(){

    }
    public Users(String username, String displayName, String phoneNumber, String email, String password, String role, String licenseNumber) {
        this.Username = username;
        this.DisplayName = displayName;
        this.PhoneNumber = phoneNumber;
        this.Email = email;
        this.Password = password;
        this.Role = role;
        this.LicenseNumber = licenseNumber;
        this.Created = LocalDateTime.now();
        this.IsActivated = false;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setUpdated(LocalDateTime updated) {
        Updated = updated;
    }

    public void setRole(String role) {
        Role = role;
    }

    public void setUserID(UUID userID) {
        UserID = userID;
    }

    public void setProfilePicture(byte[] profilePicture) {
        ProfilePicture = profilePicture;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public void setLicenseNumber(String licenseNumber) {
        LicenseNumber = licenseNumber;
    }

    public void setDeleted(LocalDateTime deleted) {
        Deleted = deleted;
    }

    public void setCreated(LocalDateTime created) {
        Created = created;
    }

    public void setActivated(boolean activated) {
        IsActivated = activated;
    }

    public void setVehicles(List<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }

    public String getUsername() {
        return Username;
    }

    public String getRole() {
        return Role;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public String getLicenseNumber() {
        return LicenseNumber;
    }

    public String getEmail() {
        return Email;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public UUID getUserID() {
        return UserID;
    }

    public LocalDateTime getUpdated() {
        return Updated;
    }

    public LocalDateTime getDeleted() {
        return Deleted;
    }

    public LocalDateTime getCreated() {
        return Created;
    }

    public byte[] getProfilePicture() {
        return ProfilePicture;
    }

    public List<Vehicles> getVehicles() {
        return vehicles;
    }
}
